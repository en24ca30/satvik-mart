package com.satvikmart.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String = "1",
    val name: String = "",
    val mobile: String = "",
    val email: String = "",
    val isLoggedIn: Boolean = false
)
