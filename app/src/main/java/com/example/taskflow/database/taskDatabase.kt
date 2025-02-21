package com.example.taskflow.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskflow.model.task

@Database(entities = [task::class], version = 1)

abstract class taskDatabase : RoomDatabase(){

    abstract  fun getTaskDao(): taskDao

    companion object{
        @Volatile
        private var instance: taskDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK){
            instance ?:
            createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                taskDatabase::class.java,
                "task_db"
            ).build()

    }
}