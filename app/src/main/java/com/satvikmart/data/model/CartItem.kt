package com.satvikmart.data.model

data class Address(
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
    val type: String,
    val isDefault: Boolean = false
)
