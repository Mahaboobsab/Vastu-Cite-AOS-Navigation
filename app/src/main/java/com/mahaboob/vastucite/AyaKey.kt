package com.mahaboob.vastucite
import AppLanguage
enum class AyaKey(val id: Int) {
    DWAJAYA(1),
    DHOOMARAYA(2),
    SIMHAYA(3),
    SHVANAYA(4),
    VRISHABAYA(5),
    KHARAYA(6),
    GAJAYA(7),
    KAKAYA(8);

    companion object {
        fun from(id: Int): AyaKey? =
            values().find { it.id == id }
    }
}

object AyaTexts {

    private val kannada = mapOf(
        AyaKey.DWAJAYA to "ದ್ವಜಯಾ",
        AyaKey.DHOOMARAYA to "ಧೂಮರಾಯ",
        AyaKey.SIMHAYA to "ಸಿಂಹಾಯಾ",
        AyaKey.SHVANAYA to "ಶ್ವಾನಾಯ",
        AyaKey.VRISHABAYA to "ವೃಷಬಾಯಾ",
        AyaKey.KHARAYA to "ಖರಾಯ",
        AyaKey.GAJAYA to "ಗಜಾಯ",
        AyaKey.KAKAYA to "ಕಾಕಾಯಾ"
    )

    private val hindi = mapOf(
        AyaKey.DWAJAYA to "ध्वजाया",
        AyaKey.DHOOMARAYA to "धूमराय",
        AyaKey.SIMHAYA to "सिंहाया",
        AyaKey.SHVANAYA to "श्वानाय",
        AyaKey.VRISHABAYA to "वृषभाय",
        AyaKey.KHARAYA to "खराय",
        AyaKey.GAJAYA to "गजाय",
        AyaKey.KAKAYA to "काकाय"
    )

    private val telugu = mapOf(
        AyaKey.DWAJAYA to "ధ్వజాయ",
        AyaKey.DHOOMARAYA to "ధూమరాయ",
        AyaKey.SIMHAYA to "సింహాయ",
        AyaKey.SHVANAYA to "శ్వానాయ",
        AyaKey.VRISHABAYA to "వృషభాయ",
        AyaKey.KHARAYA to "ఖరాయ",
        AyaKey.GAJAYA to "గజాయ",
        AyaKey.KAKAYA to "కాకాయ"
    )

    private val marathi = mapOf(
        AyaKey.DWAJAYA to "ध्वजाया",
        AyaKey.DHOOMARAYA to "धूमराय",
        AyaKey.SIMHAYA to "सिंहाया",
        AyaKey.SHVANAYA to "श्वानाय",
        AyaKey.VRISHABAYA to "वृषभाय",
        AyaKey.KHARAYA to "खराय",
        AyaKey.GAJAYA to "गजाय",
        AyaKey.KAKAYA to "काकाय"
    )

    private val english = mapOf(
        AyaKey.DWAJAYA to "Dwajaya",
        AyaKey.DHOOMARAYA to "Dhoomaraya",
        AyaKey.SIMHAYA to "Simhaya",
        AyaKey.SHVANAYA to "Shvanaya",
        AyaKey.VRISHABAYA to "Vrishabaya",
        AyaKey.KHARAYA to "Kharaya",
        AyaKey.GAJAYA to "Gajaya",
        AyaKey.KAKAYA to "Kakaya"
    )

    fun getText(key: AyaKey, language: AppLanguage): String {
        return when (language) {
            AppLanguage.ENGLISH -> english[key]
            AppLanguage.KANNADA -> kannada[key]
            AppLanguage.HINDI -> hindi[key]
            AppLanguage.TELUGU -> telugu[key]
            AppLanguage.MARATHI -> marathi[key]
        } ?: "N/A"
    }
}