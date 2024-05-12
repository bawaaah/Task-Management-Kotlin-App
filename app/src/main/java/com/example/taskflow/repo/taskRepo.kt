package com.example.taskflow.repo

import androidx.room.Query
import com.example.taskflow.database.taskDatabase
import com.example.taskflow.model.task

class taskRepo(private val db: taskDatabase){

    suspend fun insertTask(task: task) = db.getTaskDao().insertTask(task)
    suspend fun deleteTask(task: task) = db.getTaskDao().deleteTask(task)
    suspend fun updateTask(task: task) = db.getTaskDao().updateTask(task)

    fun getAllTasks() = db.getTaskDao().getAllTasks()
    fun searchTask(query: String?) = db.getTaskDao().searchTask(query)

}