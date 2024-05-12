package com.example.taskflow.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tasks")
@Parcelize
data class task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val des: String
):Parcelable
