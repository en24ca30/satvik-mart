package com.satvikmart.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coupons")
data class CouponEntity(
    @PrimaryKey
    val id: String,
    val code: String,
    val discountValue: Double,
    val discountType: String, // FIXED, PERCENTAGE
    val minOrderValue: Double,
    val maxDiscount: Double,
    val expiryDate: Long,
    val isActive: Boolean = true,
    val description: String = ""
)
