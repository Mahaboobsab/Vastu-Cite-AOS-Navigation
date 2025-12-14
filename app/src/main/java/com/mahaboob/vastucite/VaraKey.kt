package com.mahaboob.vastucite
import AppLanguage

enum class VaraKey {
    SHUBHA_ADHIKA_VRUDDHI,
    SHUBHA_AISHWARYA_DHANA,
    DHANA_KANAKA_MARYADE,
    SANTANA_VRUDDHI,
    SADHARANA_PHALA,
    NA
}

fun varaKeyFrom(result: Int): VaraKey =
    when (result) {
        2 -> VaraKey.SHUBHA_ADHIKA_VRUDDHI
        4 -> VaraKey.SHUBHA_AISHWARYA_DHANA
        5 -> VaraKey.DHANA_KANAKA_MARYADE
        6 -> VaraKey.SANTANA_VRUDDHI
        0 -> VaraKey.SADHARANA_PHALA
        else -> VaraKey.NA
    }

object VaraTexts {

    private val kannada = mapOf(
        VaraKey.SHUBHA_ADHIKA_VRUDDHI to "ಶುಭ, ಅಧಿಕ ವೃದ್ಧಿ",
        VaraKey.SHUBHA_AISHWARYA_DHANA to "ಶುಭ, ಐಶ್ವರ್ಯ, ಧನ",
        VaraKey.DHANA_KANAKA_MARYADE to "ಧನ, ಕನಕ, ಮರಿಯಾದೆ",
        VaraKey.SANTANA_VRUDDHI to "ಸಂತಾನ ವೃದ್ಧಿ",
        VaraKey.SADHARANA_PHALA to "ಸಾಧಾರಣ ಫಲ",
        VaraKey.NA to "N/A"
    )

    private val english = mapOf(
        VaraKey.SHUBHA_ADHIKA_VRUDDHI to "Auspicious, Growth",
        VaraKey.SHUBHA_AISHWARYA_DHANA to "Auspicious, Wealth & Prosperity",
        VaraKey.DHANA_KANAKA_MARYADE to "Wealth, Gold, Respect",
        VaraKey.SANTANA_VRUDDHI to "Progeny Growth",
        VaraKey.SADHARANA_PHALA to "Average Result",
        VaraKey.NA to "N/A"
    )

    private val hindi = mapOf(
        VaraKey.SHUBHA_ADHIKA_VRUDDHI to "शुभ, अधिक वृद्धि",
        VaraKey.SHUBHA_AISHWARYA_DHANA to "शुभ, ऐश्वर्य, धन",
        VaraKey.DHANA_KANAKA_MARYADE to "धन, कनक, सम्मान",
        VaraKey.SANTANA_VRUDDHI to "संतान वृद्धि",
        VaraKey.SADHARANA_PHALA to "साधारण फल",
        VaraKey.NA to "N/A"
    )

    private val telugu = mapOf(
        VaraKey.SHUBHA_ADHIKA_VRUDDHI to "శుభం, అధిక వృద్ధి",
        VaraKey.SHUBHA_AISHWARYA_DHANA to "శుభం, ఐశ్వర్యం, ధనం",
        VaraKey.DHANA_KANAKA_MARYADE to "ధనం, కనకము, గౌరవం",
        VaraKey.SANTANA_VRUDDHI to "సంతాన వృద్ధి",
        VaraKey.SADHARANA_PHALA to "సాధారణ ఫలం",
        VaraKey.NA to "N/A"
    )

    private val marathi = mapOf(
        VaraKey.SHUBHA_ADHIKA_VRUDDHI to "शुभ, अधिक वाढ",
        VaraKey.SHUBHA_AISHWARYA_DHANA to "शुभ, ऐश्वर्य, धन",
        VaraKey.DHANA_KANAKA_MARYADE to "धन, कनक, मान",
        VaraKey.SANTANA_VRUDDHI to "संतान वाढ",
        VaraKey.SADHARANA_PHALA to "साधारण फल",
        VaraKey.NA to "N/A"
    )

    fun getText(key: VaraKey, language: AppLanguage): String =
        when (language) {
            AppLanguage.ENGLISH -> english[key]
            AppLanguage.KANNADA -> kannada[key]
            AppLanguage.HINDI -> hindi[key]
            AppLanguage.TELUGU -> telugu[key]
            AppLanguage.MARATHI -> marathi[key]
        } ?: "N/A"
}
