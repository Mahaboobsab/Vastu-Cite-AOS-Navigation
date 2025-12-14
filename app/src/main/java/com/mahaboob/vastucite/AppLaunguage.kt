import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.mahaboob.vastucite.ListLabelTexts
import com.mahaboob.vastucite.LanguageManager

enum class AppLanguage(val displayName: String) {
    ENGLISH("English"),
    KANNADA("ಕನ್ನಡ"),
    HINDI("हिंदी"),
    MARATHI("मराठी"),
    TELUGU("తెలుగు")
}

enum class ResultType {
    KSHETRAPHALA,
    AAYA,
    DHANA,
    RUNA,
    AYUSHYA,
    THITHI,
    VARA,
    NAKSHATRA,
    YOGA,
    KARNA,
    AMSHA,
    DIKHPALAKARU
}


data class UiText(
    val title: String,
    val heightLabel: String,
    val widthLabel: String,
    val submit: String,
    val emptyError: String,
    val invalidError: String,
) {
    val listLabels: List<String>
        get() = ListLabelTexts.getListLabels(LanguageManager.selectedLanguage)
}



fun getUiText(lang: AppLanguage): UiText {
    return when (lang) {
        AppLanguage.ENGLISH -> UiText(
            "Enter Dimensions", "Height", "Width", "Submit",
            "Please enter both values", "Invalid input"
            //listOf("Area", "Aya", "Dhana", "Runa", "Ayushya", "Thithi", "Vara", "Nakshatra", "Yoga", "Karna", "Amsha", "Dikpalakaru")
        )
        AppLanguage.KANNADA -> UiText(
            "ಆಯಾಮಗಳನ್ನು ನಮೂದಿಸಿ", "ಉದ್ದ", "ಅಗಲ", "ಸಲ್ಲಿಸು",
            "ದಯವಿಟ್ಟು ಎರಡೂ ಮೌಲ್ಯಗಳನ್ನು ನಮೂದಿಸಿ", "ಅಮಾನ್ಯ ನಮೂದು"
        )
        AppLanguage.HINDI -> UiText(
            "आयाम दर्ज करें", "ऊँचाई", "चौड़ाई", "जमा करें",
            "कृपया दोनों मान दर्ज करें", "अमान्य इनपुट"
        )
        AppLanguage.MARATHI -> UiText(
            "मोजमाप भरा", "उंची", "रुंदी", "सबमिट",
            "कृपया दोन्ही मूल्ये भरा", "अवैध इनपुट"
        )
        AppLanguage.TELUGU -> UiText(
            "కొలతలు నమోదు చేయండి", "ఎత్తు", "వెడల్పు", "సబ్మిట్",
            "దయచేసి రెండు విలువలు నమోదు చేయండి", "చెల్లని ఇన్‌పుట్"
        )
    }
}

