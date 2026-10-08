package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.CartItemEntity
import com.satvikmart.data.model.CartItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class CartRepository(private val db: AppDatabase) {
    fun getAllCartItems(): Flow<List<CartItem>> = db.cartDao().getAllCartItems().map { it.map(CartItemEntity::toModel) }
    fun getCartItemCount(): Flow<Int> = db.cartDao().getCartItemCount()

    suspend fun addToCart(productId: String, productName: String, price: Double, imageUrl: String, quantity: Int = 1) {
        val existing = db.cartDao().getCartItem(productId)
        if (existing != null) {
            db.cartDao().updateCartItem(existing.copy(quantity = existing.quantity + quantity))
        } else {
            db.cartDao().insertCartItem(
                CartItemEntity(
                    id = UUID.randomUUID().toString(),
                    productId = productId,
                    productName = productName,
                    price = price,
                    quantity = quantity,
                    imageUrl = imageUrl
                )
            )
        }
    }

    suspend fun updateQuantity(productId: String, quantity: Int) {
        val item = db.cartDao().getCartItem(productId) ?: return
        if (quantity <= 0) db.cartDao().deleteCartItem(item)
        else db.cartDao().updateCartItem(item.copy(quantity = quantity))
    }

    suspend fun removeFromCart(productId: String) {
        val item = db.cartDao().getCartItem(productId) ?: return
        db.cartDao().deleteCartItem(item)
    }

    suspend fun clearCart() = db.cartDao().clearCart()

    private fun CartItemEntity.toModel() = CartItem(
        id = id,
        productId = productId,
        productName = productName,
        price = price,
        quantity = quantity,
        imageUrl = imageUrl
    )
}
