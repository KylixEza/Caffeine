package com.psi.caffeine.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.psi.caffeine.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface CaffeineDao {
    
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT EXISTS(SELECT * FROM user WHERE email = :email)")
    fun isEmailExist(email: String): Flow<Boolean>
    
    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    fun getUser(username: String, password: String): Flow<User>?
}