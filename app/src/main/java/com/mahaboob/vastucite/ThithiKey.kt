package com.mahaboob.vastucite

import AppLanguage
enum class ThithiKey {
    HOONIME,
    AMAVASYA,
    ASHUBHA,
    UTTAMA,
    NA
}

fun thithiKeyFrom(result: Int): ThithiKey =
    when (result) {
        15 -> ThithiKey.HOONIME
        30 -> ThithiKey.AMAVASYA
        1, 4, 8, 9, 14 -> ThithiKey.ASHUBHA
        2, 3, 5, 6, 7, 10, 11, 12, 13 -> ThithiKey.UTTAMA
        else -> ThithiKey.NA
    }

object ThithiTexts {

    private val kannada = mapOf(
        ThithiKey.HOONIME to "ಹೂನಿಮೆ",
        ThithiKey.AMAVASYA to "ಅಮವಾಸೆ",
        ThithiKey.ASHUBHA to "ಅಶುಭ",
        ThithiKey.UTTAMA to "ಉತ್ತಮ",
        ThithiKey.NA to "N/A"
    )

    private val english = mapOf(
        ThithiKey.HOONIME to "Purnima",
        ThithiKey.AMAVASYA to "Amavasya",
        ThithiKey.ASHUBHA to "Inauspicious",
        ThithiKey.UTTAMA to "Good",
        ThithiKey.NA to "N/A"
    )

    private val hindi = mapOf(
        ThithiKey.HOONIME to "पूर्णिमा",
        ThithiKey.AMAVASYA to "अमावस्या",
        ThithiKey.ASHUBHA to "अशुभ",
        ThithiKey.UTTAMA to "उत्तम",
        ThithiKey.NA to "N/A"
    )

    private val telugu = mapOf(
        ThithiKey.HOONIME to "పౌర్ణమి",
        ThithiKey.AMAVASYA to "అమావాస్య",
        ThithiKey.ASHUBHA to "అశుభం",
        ThithiKey.UTTAMA to "ఉత్తమం",
        ThithiKey.NA to "N/A"
    )

    private val marathi = mapOf(
        ThithiKey.HOONIME to "पौर्णिमा",
        ThithiKey.AMAVASYA to "अमावस्या",
        ThithiKey.ASHUBHA to "अशुभ",
        ThithiKey.UTTAMA to "उत्तम",
        ThithiKey.NA to "N/A"
    )

    fun getText(key: ThithiKey, language: AppLanguage): String =
        when (language) {
            AppLanguage.KANNADA -> kannada[key]
            AppLanguage.ENGLISH -> english[key]
            AppLanguage.HINDI -> hindi[key]
            AppLanguage.TELUGU -> telugu[key]
            AppLanguage.MARATHI -> marathi[key]
        } ?: "N/A"
}

