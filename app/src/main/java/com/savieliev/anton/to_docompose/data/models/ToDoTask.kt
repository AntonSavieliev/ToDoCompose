package com.savieliev.anton.to_docompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.savieliev.anton.to_docompose.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority,
)
