package com.mahaboob.vastucite
import AppLanguage
enum class DikkpalakaruKey(val id: Int) {
    SAKALA_SAUBHAGYA(1),
    VARUNA_DHANAKARA(5),
    KUBERA(7),
    MAHASHUBHA(0),
    ASHUBHA(-1);

    companion object {
        fun from(id: Int): DikkpalakaruKey =
            values().find { it.id == id } ?: ASHUBHA
    }
}

object DikkpalakaruTexts {

    private val kannada = mapOf(
        DikkpalakaruKey.SAKALA_SAUBHAGYA to "ಸಕಲ ಸೌಭಾಗ್ಯ",
        DikkpalakaruKey.VARUNA_DHANAKARA to "ವರುಣ ಧನಕರ ವೃದ್ದಿ",
        DikkpalakaruKey.KUBERA to "ಕುಭೇರ",
        DikkpalakaruKey.MAHASHUBHA to "ಮಹಾಶುಭ",
        DikkpalakaruKey.ASHUBHA to "ಅಶುಭ"
    )

    private val english = mapOf(
        DikkpalakaruKey.SAKALA_SAUBHAGYA to "Complete Prosperity",
        DikkpalakaruKey.VARUNA_DHANAKARA to "Wealth Growth (Varuna)",
        DikkpalakaruKey.KUBERA to "Kubera (Wealth)",
        DikkpalakaruKey.MAHASHUBHA to "Highly Auspicious",
        DikkpalakaruKey.ASHUBHA to "Inauspicious"
    )

    private val hindi = mapOf(
        DikkpalakaruKey.SAKALA_SAUBHAGYA to "संपूर्ण सौभाग्य",
        DikkpalakaruKey.VARUNA_DHANAKARA to "वरुण धन वृद्धि",
        DikkpalakaruKey.KUBERA to "कुबेर",
        DikkpalakaruKey.MAHASHUBHA to "महाशुभ",
        DikkpalakaruKey.ASHUBHA to "अशुभ"
    )

    private val telugu = mapOf(
        DikkpalakaruKey.SAKALA_SAUBHAGYA to "సర్వ సౌభాగ్యం",
        DikkpalakaruKey.VARUNA_DHANAKARA to "వరుణ ధన వృద్ధి",
        DikkpalakaruKey.KUBERA to "కుబేరుడు",
        DikkpalakaruKey.MAHASHUBHA to "మహాశుభం",
        DikkpalakaruKey.ASHUBHA to "అశుభం"
    )

    private val marathi = mapOf(
        DikkpalakaruKey.SAKALA_SAUBHAGYA to "संपूर्ण सौभाग्य",
        DikkpalakaruKey.VARUNA_DHANAKARA to "वरुण धनवृद्धी",
        DikkpalakaruKey.KUBERA to "कुबेर",
        DikkpalakaruKey.MAHASHUBHA to "महाशुभ",
        DikkpalakaruKey.ASHUBHA to "अशुभ"
    )

    fun getText(
        key: DikkpalakaruKey,
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
