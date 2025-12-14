package com.mahaboob.vastucite
import AppLanguage

enum class AmshyaKey(val id: Int) {
    NASHTA(1),
    VRUDDHI(2),
    SAMPATTI(3),
    DUKHA(4),
    MARANA_BHITI(5),
    CHORA_BHAYA(6),
    SANTANA_VRUDDHI(7),
    GOPASHU_VRUDDHI(8),
    SANTOSHA(9);

    companion object {
        fun from(id: Int): AmshyaKey =
            when (id) {
                9, 0 -> SANTOSHA
                else -> values().find { it.id == id } ?: SANTOSHA
            }
    }
}


object AmshyaTexts {

    private val kannada = mapOf(
        AmshyaKey.NASHTA to "ನಷ್ಟವು",
        AmshyaKey.VRUDDHI to "ವೃದ್ದಿಯು",
        AmshyaKey.SAMPATTI to "ಸಂಪತ್ತು",
        AmshyaKey.DUKHA to "ದುಃಖ",
        AmshyaKey.MARANA_BHITI to "ಮರಣ ಭೀತಿ",
        AmshyaKey.CHORA_BHAYA to "ಚೋರ ಭಯ",
        AmshyaKey.SANTANA_VRUDDHI to "ಸಂತಾನ ವೃದ್ದಿಯು",
        AmshyaKey.GOPASHU_VRUDDHI to "ಗೋಪಶು ವೃದ್ದಿಯು",
        AmshyaKey.SANTOSHA to "ಸಂತೋಷ"
    )

    private val english = mapOf(
        AmshyaKey.NASHTA to "Loss",
        AmshyaKey.VRUDDHI to "Growth",
        AmshyaKey.SAMPATTI to "Wealth",
        AmshyaKey.DUKHA to "Sorrow",
        AmshyaKey.MARANA_BHITI to "Fear of Death",
        AmshyaKey.CHORA_BHAYA to "Fear of Theft",
        AmshyaKey.SANTANA_VRUDDHI to "Progeny Growth",
        AmshyaKey.GOPASHU_VRUDDHI to "Cattle Prosperity",
        AmshyaKey.SANTOSHA to "Happiness"
    )

    private val hindi = mapOf(
        AmshyaKey.NASHTA to "हानि",
        AmshyaKey.VRUDDHI to "वृद्धि",
        AmshyaKey.SAMPATTI to "संपत्ति",
        AmshyaKey.DUKHA to "दुख",
        AmshyaKey.MARANA_BHITI to "मृत्यु भय",
        AmshyaKey.CHORA_BHAYA to "चोरी का भय",
        AmshyaKey.SANTANA_VRUDDHI to "संतान वृद्धि",
        AmshyaKey.GOPASHU_VRUDDHI to "पशुधन वृद्धि",
        AmshyaKey.SANTOSHA to "संतोष"
    )

    private val telugu = mapOf(
        AmshyaKey.NASHTA to "నష్టం",
        AmshyaKey.VRUDDHI to "వృద్ధి",
        AmshyaKey.SAMPATTI to "సంపద",
        AmshyaKey.DUKHA to "దుఃఖం",
        AmshyaKey.MARANA_BHITI to "మరణ భయం",
        AmshyaKey.CHORA_BHAYA to "దొంగ భయం",
        AmshyaKey.SANTANA_VRUDDHI to "సంతాన వృద్ధి",
        AmshyaKey.GOPASHU_VRUDDHI to "గోపశు వృద్ధి",
        AmshyaKey.SANTOSHA to "సంతోషం"
    )

    private val marathi = mapOf(
        AmshyaKey.NASHTA to "नाश",
        AmshyaKey.VRUDDHI to "वृद्धी",
        AmshyaKey.SAMPATTI to "संपत्ती",
        AmshyaKey.DUKHA to "दुःख",
        AmshyaKey.MARANA_BHITI to "मृत्यू भय",
        AmshyaKey.CHORA_BHAYA to "चोरीची भीती",
        AmshyaKey.SANTANA_VRUDDHI to "संतान वृद्धी",
        AmshyaKey.GOPASHU_VRUDDHI to "गोपशु वृद्धी",
        AmshyaKey.SANTOSHA to "संतोष"
    )

    fun getText(
        key: AmshyaKey,
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
