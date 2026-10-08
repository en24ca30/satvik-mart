package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.ProductEntity
import com.satvikmart.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepository(private val db: AppDatabase) {
    fun getAllProducts(): Flow<List<Product>> =
        db.productDao().getAllProducts().map { entities ->
            entities.map { it.toProduct() }
        }

    suspend fun getProductById(productId: String): Product? =
        db.productDao().getProductById(productId)?.toProduct()

    fun getProductsByCategory(category: String): Flow<List<Product>> =
        db.productDao().getProductsByCategory(category).map { entities ->
            entities.map { it.toProduct() }
        }

    fun searchProducts(query: String): Flow<List<Product>> =
        db.productDao().searchProducts(query).map { entities ->
            entities.map { it.toProduct() }
        }

    fun getBestsellerProducts(): Flow<List<Product>> =
        db.productDao().getBestsellerProducts().map { entities ->
            entities.map { it.toProduct() }
        }

    fun getFeaturedProducts(): Flow<List<Product>> =
        db.productDao().getFeaturedProducts().map { entities ->
            entities.map { it.toProduct() }
        }

    fun getAllCategories(): Flow<List<String>> =
        db.productDao().getAllCategories()

    private fun ProductEntity.toProduct() = Product(
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
        tags = tags.split(",").filter { it.isNotEmpty() }
    )
}
