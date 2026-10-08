package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.ProductEntity
import com.satvikmart.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepository(private val db: AppDatabase) {
    fun getAllProducts(): Flow<List<Product>> = db.productDao().getAllProducts().map { it.map(ProductEntity::toModel) }
    fun getProductsByCategory(category: String): Flow<List<Product>> = db.productDao().getProductsByCategory(category).map { it.map(ProductEntity::toModel) }
    fun getBestsellers(): Flow<List<Product>> = db.productDao().getBestsellerProducts().map { it.map(ProductEntity::toModel) }
    fun getFeatured(): Flow<List<Product>> = db.productDao().getFeaturedProducts().map { it.map(ProductEntity::toModel) }
    fun search(query: String): Flow<List<Product>> = db.productDao().searchProducts(query).map { it.map(ProductEntity::toModel) }
    suspend fun getProductById(productId: String): Product? = db.productDao().getProductById(productId)?.toModel()

    private fun ProductEntity.toModel() = Product(
        id = id,
        name = name,
        brand = brand,
        category = category,
        subcategory = subcategory,
        description = description,
        mrp = mrp,
        sellingPrice = sellingPrice,
        discount = discount,
        unit = unit,
        weight = weight,
        stock = stock,
        rating = rating,
        reviewCount = reviewCount,
        imageUrl = imageUrl,
        isBestseller = isBestseller,
        isFeatured = isFeatured,
        tags = tags.split(",").filter { it.isNotBlank() }
    )
}
