package com.mahaboob.vastucite
import AppLanguage

enum class NakshatraKey {
    SHUBHA,
    ASHUBHA;

    companion object {
        fun from(result: Int): NakshatraKey =
            if (result in listOf(4, 5, 8, 12, 13)) {
                SHUBHA
            } else {
                ASHUBHA
            }
    }
}

object NakshatraTexts {

    private val kannada = mapOf(
        NakshatraKey.SHUBHA to "ಶುಭ",
        NakshatraKey.ASHUBHA to "ಅಶುಭ"
    )

    private val english = mapOf(
        NakshatraKey.SHUBHA to "Auspicious",
        NakshatraKey.ASHUBHA to "Inauspicious"
    )

    private val hindi = mapOf(
        NakshatraKey.SHUBHA to "शुभ",
        NakshatraKey.ASHUBHA to "अशुभ"
    )

    private val telugu = mapOf(
        NakshatraKey.SHUBHA to "శుభం",
        NakshatraKey.ASHUBHA to "అశుభం"
    )

    private val marathi = mapOf(
        NakshatraKey.SHUBHA to "शुभ",
        NakshatraKey.ASHUBHA to "अशुभ"
    )

    fun getText(
        key: NakshatraKey,
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
