package com.satvikmart.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.satvikmart.data.database.entity.WishlistItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WishlistDao {
    @Insert
    suspend fun addToWishlist(item: WishlistItemEntity)

    @Delete
    suspend fun removeFromWishlist(item: WishlistItemEntity)

    @Query("SELECT * FROM wishlist_items")
    fun getAllWishlistItems(): Flow<List<WishlistItemEntity>>

    @Query("SELECT * FROM wishlist_items WHERE productId = :productId")
    suspend fun getWishlistItem(productId: String): WishlistItemEntity?

    @Query("DELETE FROM wishlist_items WHERE productId = :productId")
    suspend fun deleteByProductId(productId: String)
}
