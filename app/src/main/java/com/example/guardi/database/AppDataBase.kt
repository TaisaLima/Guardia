package com.example.guardi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.guardi.database.dao.EmergencyContactDao
import com.example.guardi.database.dao.UserDao
import com.example.guardi.models.EmergencyContact
import com.example.guardi.models.User
import com.example.guardi.ui.activity.EmergencyContactsActivity


@Database(entities = [User::class, EmergencyContact::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao() : UserDao

    abstract fun emergencyContactDao() : EmergencyContactDao

    companion object {
        fun instantiate(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                "Guadi.db").allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
    }
}