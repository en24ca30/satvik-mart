package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.NotificationEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class NotificationRepository(private val db: AppDatabase) {
    fun getAllNotifications(): Flow<List<NotificationEntity>> =
        db.notificationDao().getAllNotifications()

    fun getUnreadCount(): Flow<Int> = db.notificationDao().getUnreadCount()

    suspend fun addNotification(
        title: String,
        message: String,
        type: String,
        relatedOrderId: String? = null
    ) {
        val notification = NotificationEntity(
            id = UUID.randomUUID().toString(),
            title = title,
            message = message,
            type = type,
            isRead = false,
            createdAt = System.currentTimeMillis(),
            relatedOrderId = relatedOrderId
        )
        db.notificationDao().insertNotification(notification)
    }

    suspend fun markAsRead(notificationId: String) {
        // In a real app, you'd fetch and update
    }
}
