package com.example.dailymoodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailymoodapp.data.Mood
import com.example.dailymoodapp.ui.MotivationSuggestionBox
import com.example.dailymoodapp.ui.DailyActivitySuggestionBox
import com.example.dailymoodapp.ui.MusicSuggestionBox
import com.example.dailymoodapp.viewmodel.MoodViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    private val viewModel: MoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AnaEkran(viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaEkran(viewModel: MoodViewModel) {
    val moodlar by viewModel.moodList.collectAsState(initial = emptyList())
    var seciliMood by remember { mutableStateOf<Mood?>(null) }
    var duzenleEkrani by remember { mutableStateOf(false) }
    var silOnay by remember { mutableStateOf(false) }
    
    if (duzenleEkrani) {
        MoodDuzenleEkran(
            mood = seciliMood,
            onSave = { guncelMood ->
                if (seciliMood == null) {
                    viewModel.moodEkle(guncelMood)
                } else {
                    viewModel.moodGuncelle(guncelMood)
                }
                duzenleEkrani = false
                seciliMood = null
            },
            onBackClick = {
                duzenleEkrani = false
                seciliMood = null
            }
        )
    } else if (seciliMood != null) {
        MoodDetayEkran(
            mood = seciliMood!!,
            onBackClick = { seciliMood = null },
            onEditClick = { duzenleEkrani = true },
            onDeleteClick = { silOnay = true }
        )
        
        if (silOnay) {
            AlertDialog(
                onDismissRequest = { silOnay = false },
                title = { Text("Mood Sil") },
                text = { Text("Bu mood kaydını silmek istediğine emin misin?") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.moodSil(seciliMood!!)
                            seciliMood = null
                            silOnay = false
                        }
                    ) {
                        Text("Sil")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { silOnay = false }) {
                        Text("Vazgeç")
                    }
                }
            )
        }
    } else {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { 
                        Text(
                            "MoodLog",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        seciliMood = null
                        duzenleEkrani = true
                    }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Mood Ekle")
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                ZamanSelamlama()
                if (moodlar.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Henüz mood eklenmedi. '+' butonuna basıp ilk moodunu ekle.",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        items(moodlar) { mood ->
                            MoodSatir(
                                mood = mood,
                                onClick = { seciliMood = mood }
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodDetayEkran(
    mood: Mood,
    onBackClick: () -> Unit,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    val dateFormat = remember { SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()) }
    var motivasyonGoster by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mood Detayları") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Geri")
                    }
                },
                actions = {
                    IconButton(onClick = onEditClick) {
                        Icon(Icons.Default.Edit, contentDescription = "Düzenle")
                    }
                    IconButton(onClick = onDeleteClick) {
                        Icon(Icons.Default.Delete, contentDescription = "Sil")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = mood.emoji,
                    style = MaterialTheme.typography.displayLarge
                )
            }
            item {
                Text(
                    text = dateFormat.format(mood.date),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Açıklama",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = mood.description,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
            item {
                MotivationSuggestionBox(
                    moodEmoji = mood.emoji,
                    onLoaded = { motivasyonGoster = true }
                )
            }
            item {
                DailyActivitySuggestionBox(
                    moodEmoji = mood.emoji,
                    visible = motivasyonGoster
                )
            }
            item {
                MusicSuggestionBox(
                    moodEmoji = mood.emoji,
                    visible = motivasyonGoster
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodDuzenleEkran(
    mood: Mood?,
    onSave: (Mood) -> Unit,
    onBackClick: () -> Unit
) {
    var seciliEmoji by remember { mutableStateOf(mood?.emoji ?: "😊") }
    var aciklama by remember { mutableStateOf(mood?.description ?: "") }
    var kayitOnay by remember { mutableStateOf(false) }
    
    val emojiler = listOf("😊", "😌", "😢", "😡", "😴", "😍", "😔")
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (mood == null) "Mood Ekle" else "Mood Düzenle") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Geri")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Emoji seçimi
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                emojiler.forEach { emoji ->
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(
                                if (emoji == seciliEmoji) 
                                    MaterialTheme.colorScheme.primaryContainer 
                                else 
                                    Color.Transparent
                            )
                            .border(
                                width = 2.dp,
                                color = if (emoji == seciliEmoji) 
                                    MaterialTheme.colorScheme.primary 
                                else 
                                    Color.Transparent,
                                shape = CircleShape
                            )
                            .clickable { seciliEmoji = emoji },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = emoji,
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                }
            }
            
            // Açıklama girişi
            OutlinedTextField(
                value = aciklama,
                onValueChange = { aciklama = it },
                label = { Text("Nasıl hissediyorsun?") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Kaydet butonu
            Button(
                onClick = {
                    val yeniMood = Mood(
                        id = mood?.id ?: 0,
                        date = mood?.date ?: Date(),
                        emoji = seciliEmoji,
                        description = aciklama
                    )
                    onSave(yeniMood)
                    kayitOnay = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Kaydet")
            }
        }
        
        if (kayitOnay) {
            AlertDialog(
                onDismissRequest = { kayitOnay = false },
                title = { Text("Başarılı") },
                text = { Text("Mesaj kaydedildi") },
                confirmButton = {
                    TextButton(onClick = { kayitOnay = false }) {
                        Text("Tamam")
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodSatir(mood: Mood, onClick: () -> Unit) {
    val dateFormat = remember { SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()) }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = mood.emoji,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(end = 16.dp)
            )
            Column {
                Text(
                    text = dateFormat.format(mood.date),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = mood.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun ZamanSelamlama() {
    val saat = remember { Calendar.getInstance().get(Calendar.HOUR_OF_DAY) }
    val selam = when (saat) {
        in 5..11 -> "Günaydın"
        in 12..17 -> "İyi öğlenler"
        in 18..22 -> "İyi akşamlar"
        else -> "İyi geceler"
    }
    Text(
        text = selam,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 12.dp),
        textAlign = TextAlign.Center
    )
}