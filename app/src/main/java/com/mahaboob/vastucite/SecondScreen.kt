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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahaboob.vastucite.ScrollableThreeColumnList
import com.mahaboob.vastucite.getUpdatedItems

@Composable
fun SecondScreen(length: String,breadth: String, navigateToFirstScreen:(String)-> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(60.dp),
    ) {
       val updatedItems = getUpdatedItems(length.toInt(), breadth.toInt())
        ScrollableThreeColumnList(length = length, breadth = breadth, items = updatedItems)
        Button(onClick =  {
            navigateToFirstScreen("11")
        }){
            Text("Go Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    SecondScreen("22", "33") {

    }
}