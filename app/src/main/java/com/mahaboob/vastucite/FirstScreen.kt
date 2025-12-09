package com.mahaboob.vastucite


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
fun FirstScreen(modifier: Modifier = Modifier, navigationToSecondScreen:(String, String)-> Unit) {
    var height by remember { mutableStateOf("") }
    var width by remember { mutableStateOf("") }
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current // 👈 Used to dismiss keyboard
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,          // Center vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
    ) {
        Text(
            text = "ಆಯಾಮಗಳನ್ನು ನಮೂದಿಸಿ",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        OutlinedTextField(
            value = height,
            onValueChange = { input ->
                if (input.all { it.isDigit() }) height = input
            },
            label = { Text("ಉದ್ದ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = width,
            onValueChange = { input ->
                if (input.all { it.isDigit() }) width = input
            },
            label = { Text("ಅಗಲ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Button(
            onClick = {
                focusManager.clearFocus()
                if (height.isBlank() || width.isBlank()) {
                    Toast.makeText(
                        context,
                        "ದಯವಿಟ್ಟು ಎತ್ತರ ಮತ್ತು ಅಗಲ ಎರಡೂ ಮೌಲ್ಯಗಳನ್ನು ನಮೂದಿಸಿ",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val h = height.toIntOrNull()
                    val w = width.toIntOrNull()
                    if (h == null || w == null) {
                        Toast.makeText(
                            context,
                            "ಅಮಾನ್ಯ ನಮೂದು. ಸಂಪೂರ್ಣ ಸಂಖ್ಯೆಗಳನ್ನೇ ನಮೂದಿಸಿ.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        navigationToSecondScreen(h.toString(), w.toString())
                    }
                }
            },
            modifier = Modifier
                .padding(vertical = 4.dp)
        ) {
            Text("ಸಲ್ಲಿಸು")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    FirstScreen() { length, breadth ->

    }
}