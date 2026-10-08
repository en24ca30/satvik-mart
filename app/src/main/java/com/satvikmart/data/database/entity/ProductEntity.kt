package com.satvikmart.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val brand: String,
    val category: String,
    val subcategory: String,
    val description: String,
    val mrp: Double,
    val sellingPrice: Double,
    val discount: Int,
    val unit: String,
    val weight: String,
    val stock: Int,
    val rating: Float,
    val reviewCount: Int,
    val imageUrl: String,
    val isBestseller: Boolean = false,
    val isFeatured: Boolean = false,
    val tags: String = ""
)
