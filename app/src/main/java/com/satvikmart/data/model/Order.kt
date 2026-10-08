package com.satvikmart.data.model

data class Order(
    val id: String,
    val orderNumber: String,
    val totalAmount: Double,
    val discount: Double,
    val deliveryCharge: Double,
    val tax: Double,
    val paymentMethod: String,
    val paymentStatus: String,
    val orderStatus: String,
    val estimatedDeliveryMinutes: Int,
    val createdAt: Long,
    val items: List<OrderItem> = emptyList()
)

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    val quantity: Int,
    val imageUrl: String
)
