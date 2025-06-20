package com.example.dailymoodapp.data

import kotlin.random.Random

// Motivasyon önerilerini basitçe döndüren sınıf
class MotivasyonOner {
    companion object {
        private val mutlu = listOf(
            "Pozitif enerjin bulaşıcı! Böyle devam.",
            "Bu mutluluk hak edilmiş. Küçük şeyleri de kutla!",
            "Gülüşün birinin gününü güzelleştiriyor.",
            "Mutlu olmak bir seçim, harikasın!",
            "İyi ruh halin süper gücün. Başkalarına da ilham ol!"
        )
        private val sakin = listOf(
            "İç huzur çok güzel bir şey. Merkezini buluyorsun.",
            "Bu sakinlik senin gücün. Dengede kalabilirsin.",
            "Huzur içten gelir. Güzel bir şey inşa ediyorsun.",
            "Sükunetin bir hediye. Çevrendekilerle paylaş.",
            "Durgunlukta bilgelik var. Doğru yoldasın."
        )
        private val uzgun = listOf(
            "Üzgün hissetmek normal. Duyguların geçici.",
            "Bu da geçecek. Sandığından güçlüsün.",
            "Kendine nazik ol. İyileşmek zaman ister.",
            "Duyguların önemli. Destek istemekten çekinme.",
            "Üzüntü insan olmanın parçası. Yalnız değilsin."
        )
        private val sinirli = listOf(
            "Öfken sana bir şey anlatıyor. Dinle.",
            "Derin nefes al. Tepkini sen seçebilirsin.",
            "Kızgın olmak normal ama seni yönetmesin.",
            "Bu enerjiyi iyi bir şeye dönüştür. Yapabilirsin.",
            "Duyguların geçerli. Sağlıklı şekilde ifade et."
        )
        private val yorgun = listOf(
            "Dinlenmek zayıflık değil, ihtiyaçtır.",
            "Vücudunu dinle, neye ihtiyacı varsa onu ver.",
            "Çok çalıştın, biraz şarj ol.",
            "Kendine vakit ayırmak bencillik değil.",
            "Enerjin geri gelecek, sabırlı ol."
        )
        private val ask = listOf(
            "Aşk güzel bir duygu, tadını çıkar.",
            "Kalbin açık ve dolu, bu harika.",
            "Aşk dünyayı döndürüyor, sen de bunun parçasısın.",
            "Bu aşk duyguları çok değerli, bırak gitmesin.",
            "Verecek çok sevgin var, dünya buna ihtiyaç duyuyor."
        )
        private val melankoli = listOf(
            "Melankolinin de bir güzelliği var.",
            "Bu sessiz anlar derin olabilir, hayatı işliyorsun.",
            "Dalgın hissetmek normal, büyüyorsun.",
            "Duyarlılığın bir güç, başkalarını anlamanı sağlıyor.",
            "Bu ruh hali geçecek, duygular doğal olarak değişir."
        )
        // Emojiye göre motivasyon önerisi döndürür
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
            return Random.nextLong(1500, 3000)
        }
    }
} 