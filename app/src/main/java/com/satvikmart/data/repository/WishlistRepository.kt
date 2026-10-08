package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.WishlistItemEntity
import com.satvikmart.data.model.CartItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class WishlistRepository(private val db: AppDatabase) {
    fun getAllWishlistItems(): Flow<List<CartItem>> =
        db.wishlistDao().getAllWishlistItems().map { entities ->
            entities.map { it.toCartItem() }
        }

    suspend fun addToWishlist(productId: String, productName: String, price: Double, imageUrl: String) {
        val existingItem = db.wishlistDao().getWishlistItem(productId)
        if (existingItem == null) {
            val wishlistItem = WishlistItemEntity(
                id = UUID.randomUUID().toString(),
                productId = productId,
                productName = productName,
                price = price,
                imageUrl = imageUrl
            )
            db.wishlistDao().addToWishlist(wishlistItem)
        }
    }

    suspend fun removeFromWishlist(productId: String) {
        db.wishlistDao().deleteByProductId(productId)
    }

    suspend fun isInWishlist(productId: String): Boolean =
        db.wishlistDao().getWishlistItem(productId) != null

    private fun WishlistItemEntity.toCartItem() = CartItem(
        id = id,
        productId = productId,
        productName = productName,
        price = price,
        quantity = 1,
        imageUrl = imageUrl,
        addedAt = addedAt
    )
}
