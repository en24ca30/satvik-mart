package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.CartItemEntity
import com.satvikmart.data.model.CartItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class CartRepository(private val db: AppDatabase) {
    fun getAllCartItems(): Flow<List<CartItem>> =
        db.cartDao().getAllCartItems().map { entities ->
            entities.map { it.toCartItem() }
        }

    fun getCartItemCount(): Flow<Int> = db.cartDao().getCartItemCount()

    suspend fun addToCart(productId: String, productName: String, price: Double, imageUrl: String, quantity: Int = 1) {
        val existingItem = db.cartDao().getCartItem(productId)
        if (existingItem != null) {
            val updated = existingItem.copy(quantity = existingItem.quantity + quantity)
            db.cartDao().updateCartItem(updated)
        } else {
            val cartItem = CartItemEntity(
                id = UUID.randomUUID().toString(),
                productId = productId,
                productName = productName,
                price = price,
                quantity = quantity,
                imageUrl = imageUrl
            )
            db.cartDao().insertCartItem(cartItem)
        }
    }

    suspend fun removeFromCart(productId: String) {
        val item = db.cartDao().getCartItem(productId)
        if (item != null) {
            db.cartDao().deleteCartItem(item)
        }
    }

    suspend fun updateCartItemQuantity(productId: String, quantity: Int) {
        val item = db.cartDao().getCartItem(productId)
        if (item != null) {
            if (quantity <= 0) {
                db.cartDao().deleteCartItem(item)
            } else {
                db.cartDao().updateCartItem(item.copy(quantity = quantity))
            }
        }
    }

    suspend fun clearCart() {
        db.cartDao().clearCart()
    }

    private fun CartItemEntity.toCartItem() = CartItem(
        id = id,
        productId = productId,
        productName = productName,
        price = price,
        quantity = quantity,
        imageUrl = imageUrl,
        addedAt = addedAt
    )
}
