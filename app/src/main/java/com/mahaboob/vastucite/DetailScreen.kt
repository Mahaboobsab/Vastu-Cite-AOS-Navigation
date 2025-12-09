package com.mahaboob.vastucite

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DimensionInputForm(modifier: Modifier = Modifier) {
    var height by remember { mutableStateOf("") }
    var width by remember { mutableStateOf("") }
    var showList by remember { mutableStateOf(false) }
    var updatedItems by remember { mutableStateOf(emptyList<Triple<String, String, String>>()) }
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current // 👈 Used to dismiss keyboard
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp), // Removed vertical padding
        verticalArrangement = Arrangement.Top // Align everything to top
    ) {
        Text(
            text = "ಆಯಾಮಗಳನ್ನು ನಮೂದಿಸಿ",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        OutlinedTextField(
            value = height,
            onValueChange = { input ->
                if (input.all { it.isDigit() }) {
                    height = input
                }
            },
            label = { Text("ಉದ್ದ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp) // Tight spacing below
        )
        OutlinedTextField(
            value = width,
            onValueChange = { input ->
                if (input.all { it.isDigit() }) {
                    width = input
                }
            },
            label = { Text("ಅಗಲ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp) // Tight spacing below
        )
        Button(
            onClick = {
                focusManager.clearFocus()
                if (height.isBlank() || width.isBlank()) {
                    Toast.makeText(context, "ದಯವಿಟ್ಟು ಎತ್ತರ ಮತ್ತು ಅಗಲ ಎರಡೂ ಮೌಲ್ಯಗಳನ್ನು ನಮೂದಿಸಿ", Toast.LENGTH_SHORT).show()
                } else {
                    val h = height.toIntOrNull()
                    val w = width.toIntOrNull()
                    if (h == null || w == null) {
                        Toast.makeText(context, "ಅಮಾನ್ಯ ನಮೂದು. ಸಂಪೂರ್ಣ ಸಂಖ್ಯೆಗಳನ್ನೇ ನಮೂದಿಸಿ.", Toast.LENGTH_SHORT).show()
                    } else {
                       // val area = kshetraphala(h, w)
                       // val ayaResult = aya(h, w)

                        // Toast.makeText(context, "Area: $area, Aya: $ayaResult", Toast.LENGTH_SHORT).show()
                        updatedItems = getUpdatedItems(h, w)
                        showList = true
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(vertical = 4.dp) // Minimal vertical padding
        ) {
            Text("ಸಲ್ಲಿಸು")
        }
        if (showList) {
            Spacer(modifier = Modifier.height(16.dp)) // Slight spacing before list
            //ScrollableThreeColumnList(items = updatedItems)
        }
    }

}

@Composable
fun ScrollableThreeColumnList(
    length: String,
    breadth: String,
    items: List<Triple<String, String, String>>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // Header Text - must be inside item {}
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Please verify below results with experts before construction",
                fontSize = 10.sp,
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Results:  $length X $breadth",
                fontSize = 24.sp,
                color = Color.Gray

            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        // List Items
        items(items) { (label, value, extra) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = label, modifier = Modifier.weight(1f), fontSize = 12.sp)
                Text(text = value, modifier = Modifier.weight(1f), fontSize = 12.sp)
                Text(text = extra, modifier = Modifier.weight(1f), fontSize = 12.sp)
            }
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}


fun kshetraphala(a: Int, b: Int): Int {
    return a * b
}

fun aya(a: Int, b: Int): Int {
    var result = a * b
    result = result * 9
    result = result % 8
    return if (result == 0) {
        8
    } else {
        result
    }
}

fun dhana(a: Int, b: Int): Int {
    var result = a * b
    result *= 8
    result %= 12
    println("Dhana is $result") // Equivalent to NSLog
    return if (result == 0) {
        12
    } else {
        result
    }
}

fun runa(a: Int, b: Int): Int {
    var result = a * b
    result *= 3
    result %= 8
    println("runa is $result") // Equivalent to NSLog
    return if (result == 0) {
        8
    } else {
        result
    }
}

fun thithi(a: Int, b: Int): Int {
    var result = a * b
    result *= 8
    result %= 30
    println("thithi is $result")
    return if (result == 0) 30 else result
}

fun vara(a: Int, b: Int): Int {
    var result = a * b
    result *= 9
    result %= 7
    println("vara is $result")
    return if (result == 0) 7 else result
}

fun nakshatra(a: Int, b: Int): Int {
    var result = a * b
    result *= 8
    result %= 27
    println("nakshatra is $result")
    return if (result == 0) 27 else result
}

fun yoga(a: Int, b: Int): Int {
    var result = a * b
    result *= 4
    result %= 27
    println("yoga is $result")
    return if (result == 0) 27 else result
}

fun karma(a: Int, b: Int): Int {
    var result = a * b
    result *= 5
    result %= 11
    println("karma is $result")
    return if (result == 0) 11 else result
}

fun amsha(a: Int, b: Int): Int {
    var result = a * b
    result *= 6
    result %= 9
    println("amsha is $result")
    return if (result == 0) 9 else result
}

fun ayushya(a: Int, b: Int): Int {
    var result = a * b
    result *= 9
    result %= 120
    println("ayushya is $result")
    return if (result == 0) 120 else result
}

fun dikkpalakaru(a: Int, b: Int): Int {
    var result = a * b
    result *= 9
    result %= 120
    result %= 8
    println("dikkpalakaru is $result")
    return if (result == 0) 8 else result
}


fun ayaString(result: Int): String {
    println("Aya is $result")
    return when (result) {
        1 -> "ದ್ವಜಯಾ"
        2 -> "ಧೂಮರಾಯ"
        3 -> "ಸಿಂಹಾಯಾ"
        4 -> "ಶ್ವಾನಾಯ"
        5 -> "ವೃಷಬಾಯಾ"
        6 -> "ಖರಾಯ"
        7 -> "ಗಜಾಯ"
        8 -> "ಕಾಕಾಯಾ"
        else -> "N/A"
    }
}

fun thithiStr(result: Int): String {
    return when (result) {
        15 -> "ಹೂನಿಮೆ"
        30 -> "ಅಮವಾಸೆ"
        1, 4, 8, 9, 14 -> "ಅಶುಭ"
        2, 3, 5, 6, 7, 10, 11, 12, 13 -> "ಉತ್ತಮ"
        else -> "N/A"
    }
}

fun ayushyaStr(result: Int): String {
    return when {
        result < 59 -> "ಅಶುಭ"
        result > 59 -> "ಶುಭ"
        else -> ""
    }
}

fun varaStr(result: Int): String {
    return when (result) {
        2 -> "ಶುಭ, ಅಧಿಕ ವೃದ್ಧಿ"
        4 -> "ಶುಭ, ಐಶ್ವರ್ಯ,ಧನ"
        5 -> "ಧನ, ಕನಕ, ಮರಿಯಾದೆ"
        6 -> "ಸಂತಾನ ವೃದ್ಧಿ"
        0 -> "ಸಾಧಾರನ ಫಲ"
        else -> "N/A"
    }
}

fun nakshatraStr(result: Int): String {
    return when (result) {
        4, 5, 8, 12, 13 -> "ಶುಭ"
        else -> "ಅಶುಭ"
    }
}

fun yogaStr(result: Int): String {
    return when (result) {
        1, 6, 9, 10, 13, 15, 17, 19, 27 -> "ಅಶುಭ"
        else -> "ಶುಭ"
    }
}

fun karnaStr(result: Int): String {
    return when (result) {
        1, 2, 3, 4, 5 -> "ಶುಭ"
        else -> "ಅಶುಭ"
    }
}

fun amshyaStr(result: Int): String {
    return when (result) {
        1 -> "ನಸ್ಟವು"
        2 -> "ವೃದ್ದಿಯು"
        3 -> "ಸಂಪತ್ತು"
        4 -> "ದುಃಖ"
        5 -> "ಮರಣ ಬೀತಿ"
        6 -> "ಚೋರ ಭಯ"
        7 -> "ಸಂತಾನ ವೃದ್ದಿಯು"
        8 -> "ಗೋಪಷು ವೃದ್ದಿಯು"
        9, 0 -> "ಸಂತೋಷ"
        else -> "N/A"
    }
}

fun dikkpalakaruStr(result: Int): String {
    return when (result) {
        1 -> "ಸಕಲ ಸೌಭಾಗ್ಯ"
        5 -> "ವರುಣ ಧನಕರ ವೃದ್ದಿ"
        7 -> "ಕುಭೇರ"
        0 -> "ಮಹಾಶುಭ"
        else -> "ಅಶುಭ"
    }
}



fun getUpdatedItems(height: Int, width: Int): List<Triple<String, String, String>> {
    val area = kshetraphala(height, width)
    val ayaValue = aya(height, width)
    val dhanaValue = dhana(height, width)
    val runaValue = runa(height, width)
    val ayushyaValue = ayushya(height, width)
    val thithiValue = thithi(height, width)
    val varaValue = vara(height, width)
    val nakshatraValue = nakshatra(height, width)
    val yogaValue = yoga(height, width)
    val karnaValue = karma(height, width)
    val amshaValue = amsha(height, width)
    val dikkpalakaruValue = dikkpalakaru(height, width)

    var ayaname = ayaString(ayaValue)
    var ayushyaName = ayushyaStr(ayushyaValue)
    var thitiName = thithiStr(thithiValue)
    var varaName = varaStr(varaValue)
    var nakshatraName = nakshatraStr(nakshatraValue)
    var yogaName = yogaStr(yogaValue)
    var karnaName = karnaStr(karnaValue)
    var amshaName = amshyaStr(amshaValue)
    var dikpalakaruName = dikkpalakaruStr(dikkpalakaruValue)

    val originalItems = listOf(
        Triple("ಕ್ಷೇತ್ರಫಲ", "Value 1", "N/A"),
        Triple("ಆಯಾ", "Value 2", "Extra 2"),
        Triple("ಧನ", "Value 3", "N/A"),
        Triple("ರೂನ", "Value 4", "N/A"),
        Triple("ಆಯುಷ್ಯ", "Value 5", "Extra 5"),
        Triple("ತಿಥಿ", "Value 6", "Extra 6"),
        Triple("ವಾರ", "Value 6", "Extra 6"),
        Triple("ನಕ್ಷತ್ರ", "Value 6", "Extra 6"),
        Triple("ಯೋಗ", "Value 6", "Extra 6"),
        Triple("ಕರ್ಣ", "Value 6", "Extra 6"),
        Triple("ಅಂಶ", "Value 6", "Extra 6"),
        Triple("ದಿಕ್ಪಾಲಕರು", "Value 6", "Extra 6")
    )

    return originalItems.map { triple ->
        when (triple.first) {
            "ಕ್ಷೇತ್ರಫಲ" -> Triple(triple.first, area.toString(), triple.third)
            "ಆಯಾ" -> Triple(triple.first, ayaValue.toString(), ayaname)
            "ಧನ" -> Triple(triple.first, dhanaValue.toString(), triple.third)
            "ರೂನ" -> Triple(triple.first, runaValue.toString(), triple.third)
            "ಆಯುಷ್ಯ" -> Triple(triple.first, ayushyaValue.toString(), ayushyaName)
            "ತಿಥಿ" -> Triple(triple.first, thithiValue.toString(), thitiName)
            "ವಾರ" -> Triple(triple.first, varaValue.toString(), varaName)
            "ನಕ್ಷತ್ರ" -> Triple(triple.first, nakshatraValue.toString(), nakshatraName)
            "ಯೋಗ" -> Triple(triple.first, yogaValue.toString(), yogaName)
            "ಕರ್ಣ" -> Triple(triple.first, karnaValue.toString(), karnaName)
            "ಅಂಶ" -> Triple(triple.first, amshaValue.toString(), amshaName)
            "ದಿಕ್ಪಾಲಕರು" -> Triple(triple.first, dikkpalakaruValue.toString(), dikpalakaruName)
            else -> triple
        }
    }
}