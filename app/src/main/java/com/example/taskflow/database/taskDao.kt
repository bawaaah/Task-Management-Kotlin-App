package com.example.taskflow.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taskflow.model.task

@Dao

interface taskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: task)

    @Update
    suspend fun updateTask(task: task)

    @Delete
    suspend fun deleteTask(task: task)

    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAllTasks(): LiveData<List<task>>

    @Query("SELECT * FROM tasks WHERE title LIKE :query OR des LIKE :query")
    fun searchTask(query: String?): LiveData<List<task>>
}