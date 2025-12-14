package com.mahaboob.vastucite
import AppLanguage
enum class AyushyaKey {
    SHUBHA,
    ASHUBHA,
    EMPTY
}

fun ayushyaKeyFrom(result: Int): AyushyaKey =
    when {
        result < 59 -> AyushyaKey.ASHUBHA
        result > 59 -> AyushyaKey.SHUBHA
        else -> AyushyaKey.EMPTY
    }

object AyushyaTexts {

    private val kannada = mapOf(
        AyushyaKey.SHUBHA to "ಶುಭ",
        AyushyaKey.ASHUBHA to "ಅಶುಭ",
        AyushyaKey.EMPTY to ""
    )

    private val english = mapOf(
        AyushyaKey.SHUBHA to "Auspicious",
        AyushyaKey.ASHUBHA to "Inauspicious",
        AyushyaKey.EMPTY to ""
    )

    private val hindi = mapOf(
        AyushyaKey.SHUBHA to "शुभ",
        AyushyaKey.ASHUBHA to "अशुभ",
        AyushyaKey.EMPTY to ""
    )

    private val telugu = mapOf(
        AyushyaKey.SHUBHA to "శుభం",
        AyushyaKey.ASHUBHA to "అశుభం",
        AyushyaKey.EMPTY to ""
    )

    private val marathi = mapOf(
        AyushyaKey.SHUBHA to "शुभ",
        AyushyaKey.ASHUBHA to "अशुभ",
        AyushyaKey.EMPTY to ""
    )

    fun getText(key: AyushyaKey, language: AppLanguage): String =
        when (language) {
            AppLanguage.ENGLISH -> english[key]
            AppLanguage.KANNADA -> kannada[key]
            AppLanguage.HINDI -> hindi[key]
            AppLanguage.TELUGU -> telugu[key]
            AppLanguage.MARATHI -> marathi[key]
        } ?: ""
}

