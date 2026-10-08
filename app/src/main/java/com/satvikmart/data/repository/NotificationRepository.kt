package com.satvikmart.data.repository

import com.satvikmart.data.database.AppDatabase
import com.satvikmart.data.database.entity.UserEntity
import com.satvikmart.data.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepository(private val db: AppDatabase) {
    fun getUser(): Flow<User?> = db.userDao().getUser().map { it?.toModel() }
    suspend fun updateUser(user: User) {
        db.userDao().updateUser(
            UserEntity(
                id = user.id,
                name = user.name,
                mobile = user.mobile,
                email = user.email,
                isLoggedIn = user.isLoggedIn
            )
        )
    }

    private fun UserEntity.toModel() = User(
        id = id,
        name = name,
        mobile = mobile,
        email = email,
        isLoggedIn = isLoggedIn
    )
}
