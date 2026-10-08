package com.satvikmart.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notifications")
data class NotificationEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val message: String,
    val type: String, // ORDER, OFFER, DELIVERY, PROMOTION
    val isRead: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val relatedOrderId: String? = null
)
