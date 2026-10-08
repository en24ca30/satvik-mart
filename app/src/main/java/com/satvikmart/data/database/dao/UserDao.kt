package com.satvikmart.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.satvikmart.data.database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE id = '1'")
    fun getUser(): Flow<UserEntity?>

    @Query("SELECT * FROM users WHERE id = '1'")
    suspend fun getUserOnce(): UserEntity?
}
