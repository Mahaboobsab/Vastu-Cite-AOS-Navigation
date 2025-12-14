package com.mahaboob.vastucite
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import AppLanguage
import UiText
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    navigationToSecondScreen: (String, String) -> Unit
) {
    var height by remember { mutableStateOf("") }
    var width by remember { mutableStateOf("") }
    var selectedLanguage by remember { mutableStateOf(AppLanguage.KANNADA) }

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    val uiText = getUiText(selectedLanguage)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ✅ LANGUAGE DROPDOWN
        LanguageDropdown(
            selected = LanguageManager.selectedLanguage,
            onSelected = {
                LanguageManager.setLanguage(it)
            }
        )

        val uiText = getUiText(LanguageManager.selectedLanguage)


        Spacer(modifier = Modifier.height(16.dp))

        // ✅ TITLE
        Text(
            text = uiText.title,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // ✅ HEIGHT
        OutlinedTextField(
            value = height,
            onValueChange = { if (it.all(Char::isDigit)) height = it },
            label = { Text(uiText.heightLabel) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // ✅ WIDTH
        OutlinedTextField(
            value = width,
            onValueChange = { if (it.all(Char::isDigit)) width = it },
            label = { Text(uiText.widthLabel) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // ✅ SUBMIT BUTTON
        Button(
            onClick = {
                focusManager.clearFocus()

                if (height.isBlank() || width.isBlank()) {
                    Toast.makeText(context, uiText.emptyError, Toast.LENGTH_SHORT).show()
                } else {
                    navigationToSecondScreen(height, width)
                }
            },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(uiText.submit)
        }
    }
}

fun getUiText(lang: AppLanguage): UiText {
    return when (lang) {
        AppLanguage.ENGLISH -> UiText(
            "Enter Dimensions", "Height", "Width", "Submit",
            "Please enter both values", "Invalid input"
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageDropdown(
    selected: AppLanguage,
    onSelected: (AppLanguage) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    // ExposedDropdownMenuBox is the Material3 way to handle dropdowns properly
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth()
    ) {

        OutlinedTextField(
            value = selected.displayName,
            onValueChange = {},
            readOnly = true,
            label = { Text("Language") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .menuAnchor() // anchors the dropdown properly in M3
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            AppLanguage.values().forEach { lang ->
                DropdownMenuItem(
                    text = { Text(lang.displayName) },
                    onClick = {
                        onSelected(lang)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    FirstScreen() { length, breadth ->

    }
}