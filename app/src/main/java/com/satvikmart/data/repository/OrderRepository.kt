package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.OrderEntity
import com.satvikmart.data.database.entity.OrderItemEntity
import com.satvikmart.data.model.CartItem
import com.satvikmart.data.model.Order
import com.satvikmart.data.model.OrderItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class OrderRepository(private val db: AppDatabase) {
    fun getAllOrders(): Flow<List<Order>> =
        db.orderDao().getAllOrders().map { entities ->
            entities.map { orderEntity ->
                val items = db.orderDao().getOrderItems(orderEntity.id)
                orderEntity.toOrder(items)
            }
        }

    suspend fun getOrderById(orderId: String): Order? {
        val orderEntity = db.orderDao().getOrderById(orderId) ?: return null
        val items = db.orderDao().getOrderItems(orderId)
        return orderEntity.toOrder(items)
    }

    suspend fun createOrder(
        cartItems: List<CartItem>,
        addressId: String,
        paymentMethod: String,
        totalAmount: Double,
        discount: Double,
        deliveryCharge: Double,
        tax: Double
    ): Order {
        val orderId = UUID.randomUUID().toString()
        val orderNumber = "SM${System.currentTimeMillis().toString().takeLast(8)}"

        val orderEntity = OrderEntity(
            id = orderId,
            orderNumber = orderNumber,
            userId = "1",
            totalAmount = totalAmount,
            discount = discount,
            deliveryCharge = deliveryCharge,
            tax = tax,
            paymentMethod = paymentMethod,
            paymentStatus = if (paymentMethod == "COD") "PENDING" else "PENDING",
            orderStatus = "PLACED",
            addressId = addressId,
            estimatedDeliveryMinutes = 20
        )

        db.orderDao().insertOrder(orderEntity)

        val orderItems = cartItems.map { cartItem ->
            OrderItemEntity(
                id = UUID.randomUUID().toString(),
                orderId = orderId,
                productId = cartItem.productId,
                productName = cartItem.productName,
                price = cartItem.price,
                quantity = cartItem.quantity,
                imageUrl = cartItem.imageUrl
            )
        }

        db.orderDao().insertOrderItems(orderItems)
        db.cartDao().clearCart()

        return getOrderById(orderId)!!
    }

    suspend fun updateOrderStatus(orderId: String, newStatus: String) {
        val order = db.orderDao().getOrderById(orderId)
        if (order != null) {
            db.orderDao().updateOrder(
                order.copy(orderStatus = newStatus, updatedAt = System.currentTimeMillis())
            )
        }
    }

    private fun OrderEntity.toOrder(items: List<OrderItemEntity>) = Order(
        id = id,
        orderNumber = orderNumber,
        totalAmount = totalAmount,
        discount = discount,
        deliveryCharge = deliveryCharge,
        tax = tax,
        paymentMethod = paymentMethod,
        paymentStatus = paymentStatus,
        orderStatus = orderStatus,
        estimatedDeliveryMinutes = estimatedDeliveryMinutes,
        createdAt = createdAt,
        items = items.map { it.toOrderItem() }
    )

    private fun OrderItemEntity.toOrderItem() = OrderItem(
        productId = productId,
        productName = productName,
        price = price,
        quantity = quantity,
        imageUrl = imageUrl
    )
}
