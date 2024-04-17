package com.example.guardi.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.guardi.models.EmergencyContact
import com.example.guardi.models.User

@Dao
interface EmergencyContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(contact: EmergencyContact)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(contact: List<User>)

    @Query("DELETE FROM EmergencyContact WHERE name = :name")
    fun remove(name: String)

    @Query("DELETE FROM User")
    fun removeAll()

    @Query("select * from EmergencyContact")
    fun getAll() : List<EmergencyContact>?

    @Query("select * from EmergencyContact where name = :name")
    fun getContactByName(name: String): EmergencyContact?
}