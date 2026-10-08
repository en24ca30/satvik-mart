package com.satvikmart.data.model

data class NotificationItem(
    val id: String,
    val title: String,
    val message: String,
    val type: String,
    val isRead: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
