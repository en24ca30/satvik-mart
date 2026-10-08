package com.satvikmart.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey
    val id: String,
    val orderNumber: String,
    val userId: String,
    val totalAmount: Double,
    val discount: Double,
    val deliveryCharge: Double,
    val tax: Double,
    val paymentMethod: String, // UPI, COD, ONLINE
    val paymentStatus: String, // PENDING, COMPLETED, FAILED
    val orderStatus: String, // PLACED, CONFIRMED, PACKING, READY, OUT_FOR_DELIVERY, DELIVERED
    val addressId: String,
    val estimatedDeliveryMinutes: Int = 20,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
