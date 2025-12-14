package com.mahaboob.vastucite
import AppLanguage

object AlertTexts {
    fun getAlertTitle(language: AppLanguage): String {
        return when (language) {
            AppLanguage.KANNADA -> "ಚೆತನ!"
            AppLanguage.ENGLISH -> "Alert!"
            AppLanguage.HINDI -> "चेतावनी!"
            AppLanguage.TELUGU -> "హెచ్చరిక!"
            AppLanguage.MARATHI -> "सूचना!"
        }
    }

    fun getAlertMessage(language: AppLanguage): String {
        return when (language) {
            AppLanguage.KANNADA -> "ನಿರ್ಮಾಣಕ್ಕೆ ಮೊದಲು ಫಲಿತಾಂಶಗಳನ್ನು ತಜ್ಞರೊಂದಿಗೆ ಪರಿಶೀಲಿಸಿ!"
            AppLanguage.ENGLISH -> "Please verify the results with experts before construction!"
            AppLanguage.HINDI -> "निर्माण से पहले परिणामों की विशेषज्ञों से जांच करें!"
            AppLanguage.TELUGU -> "నిర్మాణానికి ముందు ఫలితాలను నిపుణులతో ధృవీకరించండి!"
            AppLanguage.MARATHI -> "निर्माणापूर्वी परिणाम तज्ज्ञांकडून तपासा!"
        }
    }

    fun getConfirmButton(language: AppLanguage): String {
        return when (language) {
            AppLanguage.KANNADA -> "ಸರಿ"
            AppLanguage.ENGLISH -> "OK"
            AppLanguage.HINDI -> "ठीक है"
            AppLanguage.TELUGU -> "సరే"
            AppLanguage.MARATHI -> "ठीक आहे"
        }
    }
}
