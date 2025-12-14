package com.mahaboob.vastucite

import AppLanguage

enum class ListLabelKey {
    KSHETRAPHALA,
    AYA,
    DHANA,
    RUNA,
    AYUSHYA,
    THITHI,
    VARA,
    NAKSHATRA,
    YOGA,
    KARNA,
    AMSHA,
    DIKKPALAKARU
}

object ListLabelTexts {

    private val kannada = mapOf(
        ListLabelKey.KSHETRAPHALA to "ಕ್ಷೇತ್ರಫಲ",
        ListLabelKey.AYA to "ಆಯಾ",
        ListLabelKey.DHANA to "ಧನ",
        ListLabelKey.RUNA to "ರೂನ",
        ListLabelKey.AYUSHYA to "ಆಯುಷ್ಯ",
        ListLabelKey.THITHI to "ತಿಥಿ",
        ListLabelKey.VARA to "ವಾರ",
        ListLabelKey.NAKSHATRA to "ನಕ್ಷತ್ರ",
        ListLabelKey.YOGA to "ಯೋಗ",
        ListLabelKey.KARNA to "ಕರ್ಣ",
        ListLabelKey.AMSHA to "ಅಂಶ",
        ListLabelKey.DIKKPALAKARU to "ದಿಕ್ಪಾಲಕರು"
    )

    private val english = mapOf(
        ListLabelKey.KSHETRAPHALA to "Kshetraphala",
        ListLabelKey.AYA to "Aya",
        ListLabelKey.DHANA to "Dhana",
        ListLabelKey.RUNA to "Runa",
        ListLabelKey.AYUSHYA to "Ayushya",
        ListLabelKey.THITHI to "Thithi",
        ListLabelKey.VARA to "Vara",
        ListLabelKey.NAKSHATRA to "Nakshatra",
        ListLabelKey.YOGA to "Yoga",
        ListLabelKey.KARNA to "Karna",
        ListLabelKey.AMSHA to "Amsha",
        ListLabelKey.DIKKPALAKARU to "Dikkpalakaru"
    )

    private val hindi = mapOf(
        ListLabelKey.KSHETRAPHALA to "क्षेत्रफल",
        ListLabelKey.AYA to "आया",
        ListLabelKey.DHANA to "धन",
        ListLabelKey.RUNA to "रूना",
        ListLabelKey.AYUSHYA to "आयुष्य",
        ListLabelKey.THITHI to "तिथि",
        ListLabelKey.VARA to "वार",
        ListLabelKey.NAKSHATRA to "नक्षत्र",
        ListLabelKey.YOGA to "योग",
        ListLabelKey.KARNA to "कर्ण",
        ListLabelKey.AMSHA to "अंश",
        ListLabelKey.DIKKPALAKARU to "दिक्पालकरु"
    )

    private val telugu = mapOf(
        ListLabelKey.KSHETRAPHALA to "క్షేత్రఫలం",
        ListLabelKey.AYA to "ఆయా",
        ListLabelKey.DHANA to "ధన",
        ListLabelKey.RUNA to "రూన",
        ListLabelKey.AYUSHYA to "ఆయుష్య",
        ListLabelKey.THITHI to "తిథి",
        ListLabelKey.VARA to "వారం",
        ListLabelKey.NAKSHATRA to "నక్షత్రం",
        ListLabelKey.YOGA to "యోగ",
        ListLabelKey.KARNA to "కర్ణ",
        ListLabelKey.AMSHA to "అంశం",
        ListLabelKey.DIKKPALAKARU to "దిక్పాలకరువు"
    )

    private val marathi = mapOf(
        ListLabelKey.KSHETRAPHALA to "क्षेत्रफल",
        ListLabelKey.AYA to "आया",
        ListLabelKey.DHANA to "धन",
        ListLabelKey.RUNA to "रूना",
        ListLabelKey.AYUSHYA to "आयुष्य",
        ListLabelKey.THITHI to "तिथि",
        ListLabelKey.VARA to "वार",
        ListLabelKey.NAKSHATRA to "नक्षत्र",
        ListLabelKey.YOGA to "योग",
        ListLabelKey.KARNA to "कर्ण",
        ListLabelKey.AMSHA to "अंश",
        ListLabelKey.DIKKPALAKARU to "दिक्पालकरु"
    )

    fun getListLabels(language: AppLanguage): List<String> {
        val map = when (language) {
            AppLanguage.KANNADA -> kannada
            AppLanguage.ENGLISH -> english
            AppLanguage.HINDI -> hindi
            AppLanguage.TELUGU -> telugu
            AppLanguage.MARATHI -> marathi
        }
        return ListLabelKey.values().map { map[it] ?: "N/A" }
    }
}
