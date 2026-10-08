package com.satvikmart.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wishlist_items")
data class WishlistItemEntity(
    @PrimaryKey
    val id: String,
    val productId: String,
    val productName: String,
    val price: Double,
    val imageUrl: String,
    val addedAt: Long = System.currentTimeMillis()
)
