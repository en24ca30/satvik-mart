package com.satvikmart.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.satvikmart.data.database.dao.*
import com.satvikmart.data.database.entity.*
import com.satvikmart.util.SampleDataGenerator

@Database(
    entities = [
        ProductEntity::class,
        CartItemEntity::class,
        UserEntity::class,
        AddressEntity::class,
        OrderEntity::class,
        OrderItemEntity::class,
        CategoryEntity::class,
        WishlistItemEntity::class,
        CouponEntity::class,
        NotificationEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun cartDao(): CartDao
    abstract fun userDao(): UserDao
    abstract fun addressDao(): AddressDao
    abstract fun orderDao(): OrderDao
    abstract fun wishlistDao(): WishlistDao
    abstract fun couponDao(): CouponDao
    abstract fun notificationDao(): NotificationDao

    suspend fun seedDatabase() {
        val productDao = productDao()
        val couponDao = couponDao()
        val userDao = userDao()

        // Check if already seeded
        val existingProducts = productDao.getAllProducts()
        var hasProducts = false
        existingProducts.collect { products ->
            hasProducts = products.isNotEmpty()
        }

        if (!hasProducts) {
            productDao.insertAll(SampleDataGenerator.generateProducts())
            couponDao.insertAll(SampleDataGenerator.generateCoupons())
            userDao.insertUser(
                UserEntity(
                    id = "1",
                    name = "Demo User",
                    mobile = "9999999999",
                    email = "demo@satvikmart.com",
                    isLoggedIn = false
                )
            )
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context? = null): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context ?: throw IllegalStateException("Context is required"),
                    AppDatabase::class.java,
                    "satvik_mart_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
