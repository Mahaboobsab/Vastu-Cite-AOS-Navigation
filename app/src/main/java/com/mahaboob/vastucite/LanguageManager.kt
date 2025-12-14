package com.mahaboob.vastucite
import AppLanguage
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object LanguageManager {

    var selectedLanguage by mutableStateOf(AppLanguage.ENGLISH)
        private set

    fun setLanguage(language: AppLanguage) {
        selectedLanguage = language
    }
}
