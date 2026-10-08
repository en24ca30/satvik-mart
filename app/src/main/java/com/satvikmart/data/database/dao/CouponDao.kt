package com.satvikmart.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.satvikmart.data.database.entity.CouponEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CouponDao {
    @Insert
    suspend fun insertAll(coupons: List<CouponEntity>)

    @Query("SELECT * FROM coupons WHERE isActive = 1")
    fun getActiveCoupons(): Flow<List<CouponEntity>>

    @Query("SELECT * FROM coupons WHERE code = :code AND isActive = 1")
    suspend fun getCouponByCode(code: String): CouponEntity?

    @Query("DELETE FROM coupons")
    suspend fun deleteAll()
}
