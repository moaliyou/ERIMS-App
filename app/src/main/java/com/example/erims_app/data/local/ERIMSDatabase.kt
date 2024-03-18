package com.example.erims_app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.erims_app.data.local.dao.EmployeeDao
import com.example.erims_app.data.local.entities.Employee

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class ERIMSDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {
        @Volatile
        private var Instance: ERIMSDatabase? = null

        fun getDatabase(context: Context): ERIMSDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ERIMSDatabase::class.java, "erims_database")
                    /**
                     * Setting this option in your app's database builder means that Room
                     * permanently deletes all data from the tables in your database when it
                     * attempts to perform a migration with no defined migration path.
                     */
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}