package com.example.dailymoodapp.data

import kotlin.random.Random

// Returns simple motivation suggestions
class MotivationSuggestionEngine {
    companion object {
        private val happy = listOf(
            "Your positive energy is contagious! Keep spreading joy wherever you go.",
            "This happiness is well-deserved. Celebrate your wins, big and small!",
            "Your smile brightens someone's day. Keep that beautiful energy flowing!",
            "Happiness is a choice you're making every day. You're doing amazing!",
            "Your good mood is your superpower. Use it to inspire others!"
        )
        private val calm = listOf(
            "Inner peace is a beautiful state to be in. You're finding your center.",
            "This calmness is your strength. Trust in your ability to stay grounded.",
            "Peace comes from within. You're cultivating something precious.",
            "Your tranquility is a gift. Share it with the world around you.",
            "In stillness, you find wisdom. You're on the right path."
        )
        private val sad = listOf(
            "It's okay to feel sad. Your emotions are valid and temporary.",
            "This too shall pass. You're stronger than you know.",
            "Be gentle with yourself today. Healing takes time and patience.",
            "Your feelings matter. Don't hesitate to reach out for support.",
            "Sadness is part of being human. You're not alone in this."
        )
        private val angry = listOf(
            "Your anger is telling you something important. Listen to what it needs.",
            "Take deep breaths. You have the power to choose your response.",
            "It's okay to feel angry, but don't let it control you.",
            "Channel this energy into something positive. You're capable of great things.",
            "Your feelings are valid. Find healthy ways to express them."
        )
        private val tired = listOf(
            "Rest is not a sign of weakness. It's essential for your well-being.",
            "Listen to your body. It's asking for what it needs.",
            "You've been working hard. It's time to recharge and refresh.",
            "Self-care isn't selfish. Take the time you need to rest.",
            "Your energy will return. Be patient and kind to yourself."
        )
        private val love = listOf(
            "Love is a beautiful emotion. Cherish these feelings.",
            "Your heart is open and full. That's a beautiful thing.",
            "Love makes the world go round. You're part of something special.",
            "These feelings of love are precious. Hold onto them.",
            "You have so much love to give. The world needs more of that."
        )
        private val melancholy = listOf(
            "Melancholy has its own beauty. It's part of your depth.",
            "These quiet moments can be profound. You're processing life.",
            "It's okay to feel contemplative. You're growing and evolving.",
            "Your sensitivity is a strength. It helps you understand others.",
            "This mood will shift. Trust in the natural flow of emotions."
        )
        // Returns a motivation suggestion for the given emoji
        fun getForMood(emoji: String): String {
            return when (emoji) {
                "😊" -> happy.random()
                "😌" -> calm.random()
                "😢" -> sad.random()
                "😡" -> angry.random()
                "😴" -> tired.random()
                "😍" -> love.random()
                "😔" -> melancholy.random()
                else -> happy.random()
            }
        }

        fun loadingTime(): Long {
            return Random.nextLong(1500, 3000)
        }
    }
} 