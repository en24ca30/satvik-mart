package com.satvikmart.data.model

data class CartItem(
    val id: String,
    val productId: String,
    val productName: String,
    val price: Double,
    val quantity: Int,
    val imageUrl: String,
    val addedAt: Long = System.currentTimeMillis()
)
