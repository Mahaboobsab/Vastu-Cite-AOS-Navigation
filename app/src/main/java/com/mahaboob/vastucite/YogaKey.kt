package com.mahaboob.vastucite
import AppLanguage

enum class YogaKey {
    SHUBHA,
    ASHUBHA;

    companion object {
        fun from(result: Int): YogaKey =
            if (result in listOf(1, 6, 9, 10, 13, 15, 17, 19, 27)) {
                ASHUBHA
            } else {
                SHUBHA
            }
    }
}
object YogaTexts {

    private val kannada = mapOf(
        YogaKey.SHUBHA to "ಶುಭ",
        YogaKey.ASHUBHA to "ಅಶುಭ"
    )

    private val english = mapOf(
        YogaKey.SHUBHA to "Auspicious",
        YogaKey.ASHUBHA to "Inauspicious"
    )

    private val hindi = mapOf(
        YogaKey.SHUBHA to "शुभ",
        YogaKey.ASHUBHA to "अशुभ"
    )

    private val telugu = mapOf(
        YogaKey.SHUBHA to "శుభం",
        YogaKey.ASHUBHA to "అశుభం"
    )

    private val marathi = mapOf(
        YogaKey.SHUBHA to "शुभ",
        YogaKey.ASHUBHA to "अशुभ"
    )

    fun getText(
        key: YogaKey,
        language: AppLanguage
    ): String {
        return when (language) {
            AppLanguage.ENGLISH -> english[key]
            AppLanguage.KANNADA -> kannada[key]
            AppLanguage.HINDI -> hindi[key]
            AppLanguage.TELUGU -> telugu[key]
            AppLanguage.MARATHI -> marathi[key]
        } ?: "N/A"
    }
}

