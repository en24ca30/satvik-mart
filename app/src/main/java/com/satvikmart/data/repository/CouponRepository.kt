package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.CouponEntity
import com.satvikmart.data.model.Coupon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CouponRepository(private val db: AppDatabase) {
    fun getActiveCoupons(): Flow<List<Coupon>> =
        db.couponDao().getActiveCoupons().map { entities ->
            entities.map { it.toCoupon() }
        }

    suspend fun getCouponByCode(code: String): Coupon? =
        db.couponDao().getCouponByCode(code)?.toCoupon()

    suspend fun validateCoupon(code: String, cartTotal: Double): Pair<Boolean, String> {
        val coupon = db.couponDao().getCouponByCode(code) ?: return Pair(false, "Coupon not found")
        if (!coupon.isActive) return Pair(false, "Coupon is expired")
        if (cartTotal < coupon.minOrderValue) return Pair(false, "Minimum order value not met")
        return Pair(true, "Coupon applied successfully")
    }

    private fun CouponEntity.toCoupon() = Coupon(
        id = id,
        code = code,
        discountValue = discountValue,
        discountType = discountType,
        minOrderValue = minOrderValue,
        maxDiscount = maxDiscount,
        expiryDate = expiryDate,
        isActive = isActive,
        description = description
    )
}
