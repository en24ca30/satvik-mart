package com.satvikmart.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.satvikmart.data.database.dao.AddressDao
import com.satvikmart.data.database.dao.CartDao
import com.satvikmart.data.database.dao.CouponDao
import com.satvikmart.data.database.dao.NotificationDao
import com.satvikmart.data.database.dao.ProductDao
import com.satvikmart.data.database.dao.UserDao
import com.satvikmart.data.database.entity.AddressEntity
import com.satvikmart.data.database.entity.CartItemEntity
import com.satvikmart.data.database.entity.CouponEntity
import com.satvikmart.data.database.entity.NotificationEntity
import com.satvikmart.data.database.entity.ProductEntity
import com.satvikmart.data.database.entity.UserEntity
import com.satvikmart.util.SampleDataGenerator
import kotlinx.coroutines.flow.first

@Database(
    entities = [
        ProductEntity::class,
        CartItemEntity::class,
        AddressEntity::class,
        CouponEntity::class,
        UserEntity::class,
        NotificationEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun cartDao(): CartDao
    abstract fun addressDao(): AddressDao
    abstract fun couponDao(): CouponDao
    abstract fun userDao(): UserDao
    abstract fun notificationDao(): NotificationDao

    suspend fun seedDatabase() {
        val pDao = productDao()
        val cDao = couponDao()
        val uDao = userDao()

        val products = pDao.getAllProducts().first()
        if (products.isEmpty()) {
            pDao.insertAll(SampleDataGenerator.generateProducts())
        }

        val coupons = cDao.getActiveCoupons().first()
        if (coupons.isEmpty()) {
            cDao.insertAll(SampleDataGenerator.generateCoupons())
        }

        val user = uDao.getUserOnce()
        if (user == null) {
            uDao.insertUser(
                UserEntity(
                    id = "1",
                    name = "Demo User",
                    mobile = "9999999999",
                    email = "demo@satvikmart.com",
                    isLoggedIn = true
                )
            )
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "satvikmart.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
