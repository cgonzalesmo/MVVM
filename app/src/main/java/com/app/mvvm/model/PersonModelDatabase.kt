package com.app.mvvm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PersonModel::class), version = 1, exportSchema = false)
abstract class PersonModelDatabase : RoomDatabase() {
    abstract fun getPersonsDao(): PersonModelDao

    companion object{

        @Volatile
        private var INSTANCE: PersonModelDatabase? =null

        fun getDatabase(context: Context): PersonModelDatabase{
            return INSTANCE ?: synchronized(this){
                val instace = Room.databaseBuilder(
                    context.applicationContext,
                    PersonModelDatabase::class.java,
                    "person_database"
                ).build()
                INSTANCE = instace
                instace
            }
        }
    }
}