package com.example.erims_app.data.local

import androidx.room.Database
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.erims_app.data.local.dao.EmployeeDao
import com.example.erims_app.data.local.entities.Employee

@Database(
    entities = [
        Employee::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ERIMSDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {
        @Volatile
        private var instance: ERIMSDatabase? = null

        fun getInstance(context: Context): ERIMSDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    ERIMSDatabase::class.java,
                    "erims_database"
                ).build().also { instance = it }
            }
        }
    }

}