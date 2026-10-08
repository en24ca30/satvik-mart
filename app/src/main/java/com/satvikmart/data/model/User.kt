package com.satvikmart.data.model

data class Coupon(
    val id: String,
    val code: String,
    val discountValue: Double,
    val discountType: String,
    val minOrderValue: Double,
    val maxDiscount: Double,
    val expiryDate: Long,
    val isActive: Boolean = true,
    val description: String = ""
)
