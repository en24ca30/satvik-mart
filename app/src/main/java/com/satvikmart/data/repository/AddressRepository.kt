package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.model.Coupon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CouponRepository(private val db: AppDatabase) {
    fun getActiveCoupons(): Flow<List<Coupon>> = db.couponDao().getActiveCoupons().map { list ->
        list.map { coupon ->
            Coupon(
                id = coupon.id,
                code = coupon.code,
                discountValue = coupon.discountValue,
                discountType = coupon.discountType,
                minOrderValue = coupon.minOrderValue,
                maxDiscount = coupon.maxDiscount,
                expiryDate = coupon.expiryDate,
                isActive = coupon.isActive,
                description = coupon.description
            )
        }
    }

    suspend fun validate(code: String, cartTotal: Double): Pair<Boolean, String> {
        val coupon = db.couponDao().getCouponByCode(code.uppercase()) ?: return false to "Invalid coupon"
        if (!coupon.isActive) return false to "Coupon is inactive"
        if (cartTotal < coupon.minOrderValue) return false to "Minimum amount not reached"
        return true to "Coupon applied successfully"
    }
}
