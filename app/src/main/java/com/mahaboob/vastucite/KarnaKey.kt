package com.mahaboob.vastucite
import AppLanguage

enum class KarnaKey {
    SHUBHA,
    ASHUBHA;

    companion object {
        fun from(result: Int): KarnaKey =
            if (result in 1..5) SHUBHA else ASHUBHA
    }
}

object KarnaTexts {

    private val kannada = mapOf(
        KarnaKey.SHUBHA to "ಶುಭ",
        KarnaKey.ASHUBHA to "ಅಶುಭ"
    )

    private val english = mapOf(
        KarnaKey.SHUBHA to "Auspicious",
        KarnaKey.ASHUBHA to "Inauspicious"
    )

    private val hindi = mapOf(
        KarnaKey.SHUBHA to "शुभ",
        KarnaKey.ASHUBHA to "अशुभ"
    )

    private val telugu = mapOf(
        KarnaKey.SHUBHA to "శుభం",
        KarnaKey.ASHUBHA to "అశుభం"
    )

    private val marathi = mapOf(
        KarnaKey.SHUBHA to "शुभ",
        KarnaKey.ASHUBHA to "अशुभ"
    )

    fun getText(
        key: KarnaKey,
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

