package com.mahaboob.navigationdemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahaboob.vastucite.ScrollableThreeColumnList
import com.mahaboob.vastucite.getUpdatedItems
import com.mahaboob.vastucite.LanguageManager
import com.mahaboob.vastucite.AlertTexts
@Composable
fun SecondScreen(
    length: String,
    breadth: String,
    navigateToFirstScreen: (String) -> Unit
) {
    val showDialog = remember { mutableStateOf(false) }
    val selectedLanguage = LanguageManager.selectedLanguage
    androidx.compose.runtime.LaunchedEffect(Unit) {
        showDialog.value = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(60.dp),
    ) {

        val updatedItems = getUpdatedItems(length.toInt(), breadth.toInt(), language = selectedLanguage)
        ScrollableThreeColumnList(
            length = length,
            breadth = breadth,
            items = updatedItems
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navigateToFirstScreen("11") }) {
            Text("Go Back")
        }
    }

    if (showDialog.value) {
        val language = LanguageManager.selectedLanguage

        androidx.compose.material3.AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = AlertTexts.getAlertTitle(language)) },
            text = { Text(text = AlertTexts.getAlertMessage(language)) },
            confirmButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text(AlertTexts.getConfirmButton(language))
                }
            }
        )
    }

}


@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    SecondScreen("22", "33") { }
}
