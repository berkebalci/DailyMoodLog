package com.example.dailymoodapp.data

import kotlin.random.Random

// Müzik önerilerini basitçe döndüren nesne
object MuzikOner {
    private val muzikHarita = mapOf(
        "😊" to listOf(
            "https://www.youtube.com/watch?v=ZbZSe6N_BXs", // Happy - Pharrell Williams
            "https://open.spotify.com/track/6JV2JOEocMgcZxYSZelKcc", // Can't Stop The Feeling - Justin Timberlake
            "https://www.youtube.com/watch?v=PT2_F-1esPk" // Cheerleader - OMI
        ),
        "😌" to listOf(
            "https://www.youtube.com/watch?v=1ZYbU82GVz4", // Weightless - Marconi Union
            "https://open.spotify.com/track/2X485T9Z5Ly0xyaghN73ed", // Sunflower - Rex Orange County
            "https://www.youtube.com/watch?v=V1Pl8CzNzCw" // Sunday Best - Surfaces
        ),
        "😢" to listOf(
            "https://www.youtube.com/watch?v=RgKAFK5djSk", // See You Again - Wiz Khalifa
            "https://open.spotify.com/track/7qEHsqek33rTcFNT9PFqLf", // Someone You Loved - Lewis Capaldi
            "https://www.youtube.com/watch?v=JGwWNGJdvx8" // Shape of You - Ed Sheeran
        ),
        "😡" to listOf(
            "https://www.youtube.com/watch?v=YVkUvmDQ3HY", // Lose Yourself - Eminem
            "https://open.spotify.com/track/2Fxmhks0bxGSBdJ92vM42m", // In The End - Linkin Park
            "https://www.youtube.com/watch?v=ktvTqknDobU" // Radioactive - Imagine Dragons
        ),
        "😴" to listOf(
            "https://www.youtube.com/watch?v=2OEL4P1Rz04", // Clair de Lune - Debussy
            "https://open.spotify.com/track/0ofbQMrRDsUaVKq2mGLEAb", // River Flows In You - Yiruma
            "https://www.youtube.com/watch?v=1ZYbU82GVz4" // Weightless - Marconi Union
        ),
        "😍" to listOf(
            "https://www.youtube.com/watch?v=450p7goxZqg", // Perfect - Ed Sheeran
            "https://open.spotify.com/track/6b8Be6ljOzmkOmFslEb23P", // All of Me - John Legend
            "https://www.youtube.com/watch?v=09R8_2nJtjg" // Sugar - Maroon 5
        ),
        "😔" to listOf(
            "https://www.youtube.com/watch?v=8UVNT4wvIGY", // Somebody That I Used To Know - Gotye
            "https://open.spotify.com/track/1rqqCSm0Qe4I9rUvWncaom", // Let Her Go - Passenger
            "https://www.youtube.com/watch?v=RB-RcX5DS5A" // Let It Go - James Bay
        )
    )
    // Emojiye göre müzik linki döndürür
    fun getir(emoji: String): String {
        val sarkilar = muzikHarita[emoji]
        return if (sarkilar != null && sarkilar.isNotEmpty()) {
            sarkilar[Random.nextInt(sarkilar.size)]
        } else {
            // Bilinmeyen mood için varsayılan şarkı
            "https://www.youtube.com/watch?v=dQw4w9WgXcQ" // Rick Astley - Never Gonna Give You Up
        }
    }
} 