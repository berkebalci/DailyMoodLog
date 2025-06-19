package com.example.dailymoodapp.data

import kotlin.random.Random

class DailyActivitySuggestionEngine {
    companion object {
        private val happyActivities = listOf(
            "Go for a walk in the park and enjoy the sunshine!",
            "Call a friend and share your happiness.",
            "Listen to your favorite upbeat music.",
            "Do something creative, like drawing or writing.",
            "Treat yourself to your favorite snack."
        )
        private val calmActivities = listOf(
            "Try a short meditation or breathing exercise.",
            "Read a book in a cozy spot.",
            "Take a relaxing bath or shower.",
            "Do some gentle stretching or yoga.",
            "Light a candle and enjoy the calm atmosphere."
        )
        private val sadActivities = listOf(
            "Write your feelings in a journal.",
            "Watch a comforting movie or show.",
            "Reach out to someone you trust.",
            "Go for a gentle walk outside.",
            "Do something kind for yourself."
        )
        private val angryActivities = listOf(
            "Do a physical activity, like running or punching a pillow.",
            "Write down what's making you angry, then tear up the paper.",
            "Listen to calming music.",
            "Take a few deep breaths and count to ten.",
            "Try drawing or painting your feelings."
        )
        private val tiredActivities = listOf(
            "Take a short nap if you can.",
            "Drink a glass of water and stretch.",
            "Step outside for some fresh air.",
            "Listen to relaxing music with your eyes closed.",
            "Do a quick tidy-up of your space."
        )
        private val loveActivities = listOf(
            "Write a note to someone you care about.",
            "Do a small act of kindness for someone.",
            "Spend quality time with a loved one.",
            "Look through happy photos or memories.",
            "Express your feelings through art or music."
        )
        private val melancholyActivities = listOf(
            "Take a slow walk and reflect on your thoughts.",
            "Listen to music that matches your mood.",
            "Write poetry or a short story.",
            "Spend time in nature, even if just by a window.",
            "Try a new hobby or revisit an old one."
        )
        fun getActivityForMood(emoji: String): String {
            return when (emoji) {
                "😊" -> happyActivities.random()
                "😌" -> calmActivities.random()
                "😢" -> sadActivities.random()
                "😡" -> angryActivities.random()
                "😴" -> tiredActivities.random()
                "😍" -> loveActivities.random()
                "😔" -> melancholyActivities.random()
                else -> happyActivities.random()
            }
        }
        fun simulateLoadingTime(): Long {
            // Simulate realistic loading time between 1.2 and 2.5 seconds
            return Random.nextLong(1200, 2500)
        }
    }
} 