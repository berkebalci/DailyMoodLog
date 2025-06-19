package com.example.dailymoodapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "moods")
data class Mood(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: Date,
    val emoji: String,
    val description: String
) 