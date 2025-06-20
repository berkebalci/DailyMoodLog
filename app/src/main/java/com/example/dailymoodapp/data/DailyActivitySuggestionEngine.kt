package com.example.dailymoodapp.data

import kotlin.random.Random

// Günlük aktivite önerilerini basitçe döndüren sınıf
class AktiviteOner {
    companion object {
        private val mutlu = listOf(
            "Parkta yürüyüş yap, güneşin tadını çıkar!",
            "Bir arkadaşını ara, mutluluğunu paylaş.",
            "En sevdiğin hareketli müziği dinle.",
            "Çizim ya da yazı gibi yaratıcı bir şey yap.",
            "Kendine en sevdiğin atıştırmalıktan al."
        )
        private val sakin = listOf(
            "Kısa bir meditasyon ya da nefes egzersizi dene.",
            "Rahat bir köşede kitap oku.",
            "Rahatlatıcı bir duş al.",
            "Hafif esneme ya da yoga yap.",
            "Bir mum yak, ortamı huzurlu yap."
        )
        private val uzgun = listOf(
            "Duygularını bir deftere yaz.",
            "Rahatlatıcı bir film/dizi izle.",
            "Güvendiğin biriyle konuş.",
            "Dışarıda hafif bir yürüyüş yap.",
            "Kendine küçük bir iyilik yap."
        )
        private val sinirli = listOf(
            "Koşu yap ya da yastık yumrukla.",
            "Seni sinirlendiren şeyi yaz, sonra kağıdı yırt.",
            "Sakinleştirici müzik dinle.",
            "Derin nefes al, 10'a kadar say.",
            "Duygularını çizerek ifade et."
        )
        private val yorgun = listOf(
            "Kısa bir şekerleme yap.",
            "Bir bardak su iç, esne.",
            "Temiz hava almak için dışarı çık.",
            "Gözlerini kapatıp rahatlatıcı müzik dinle.",
            "Odanı hızlıca toparla."
        )
        private val ask = listOf(
            "Sevdiğin birine not yaz.",
            "Birine küçük bir iyilik yap.",
            "Sevdiğinle vakit geçir.",
            "Mutlu fotoğraflara bak.",
            "Duygularını sanatla ifade et."
        )
        private val melankoli = listOf(
            "Yavaşça yürü, düşün.",
            "Moduna uygun müzik dinle.",
            "Şiir ya da kısa hikaye yaz.",
            "Doğada vakit geçir (pencere bile olur).",
            "Yeni bir hobi dene ya da eskiye dön."
        )
        // Emojiye göre aktivite önerisi döndürür
        fun getir(emoji: String): String {
            return when (emoji) {
                "😊" -> mutlu.random()
                "😌" -> sakin.random()
                "😢" -> uzgun.random()
                "😡" -> sinirli.random()
                "😴" -> yorgun.random()
                "😍" -> ask.random()
                "😔" -> melankoli.random()
                else -> mutlu.random()
            }
        }
        // Yükleme süresini taklit eder
        fun yuklemeSuresi(): Long {
            return Random.nextLong(1200, 2500)
        }
    }
} 