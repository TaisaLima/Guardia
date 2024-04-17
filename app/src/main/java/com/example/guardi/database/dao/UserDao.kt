package com.example.guardi.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.guardi.models.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(user: List<User>)

    @Query("DELETE FROM User WHERE userId = :userId")
    fun remove(userId: String)

    @Query("DELETE FROM User")
    fun removeAll()

    @Query("select * from User where email = :email and password = :password")
    fun getUserByCredentials(email: String, password: String): User?
}