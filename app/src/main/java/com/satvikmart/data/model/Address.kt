package com.satvikmart.data.model

data class Product(
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
    val tags: List<String> = emptyList()
)
