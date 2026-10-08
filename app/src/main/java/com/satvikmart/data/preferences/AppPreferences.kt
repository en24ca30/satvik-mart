package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.NotificationEntity
import com.satvikmart.data.model.NotificationItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class NotificationRepository(private val db: AppDatabase) {
    fun getAllNotifications(): Flow<List<NotificationItem>> = db.notificationDao().getAllNotifications().map { list -> list.map(NotificationEntity::toModel) }

    suspend fun addNotification(title: String, message: String, type: String) {
        db.notificationDao().insertNotification(
            NotificationEntity(
                id = UUID.randomUUID().toString(),
                title = title,
                message = message,
                type = type,
                isRead = false,
                createdAt = System.currentTimeMillis()
            )
        )
    }

    private fun NotificationEntity.toModel() = NotificationItem(
        id = id,
        title = title,
        message = message,
        type = type,
        isRead = isRead,
        createdAt = createdAt
    )
}
