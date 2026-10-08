package com.satvikmart.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "addresses")
data class AddressEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val mobile: String,
    val houseFlat: String,
    val street: String,
    val area: String,
    val landmark: String,
    val city: String,
    val state: String,
    val pin: String,
    val type: String, // Home, Work, Other
    val isDefault: Boolean = false
)
