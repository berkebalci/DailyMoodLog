package com.example.dailymoodapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailymoodapp.data.Mood
import com.example.dailymoodapp.data.MoodDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MoodViewModel(application: Application) : AndroidViewModel(application) {
    private val database = MoodDatabase.getDatabase(application)
    private val moodDao = database.moodDao()
    
    val moods: Flow<List<Mood>> = moodDao.getAllMoods()

    fun addMood(mood: Mood) {
        viewModelScope.launch {
            moodDao.insertMood(mood)
        }
    }

    fun updateMood(mood: Mood) {
        viewModelScope.launch {
            moodDao.updateMood(mood)
        }
    }

    fun deleteMood(mood: Mood) {
        viewModelScope.launch {
            moodDao.deleteMood(mood)
        }
    }
} 