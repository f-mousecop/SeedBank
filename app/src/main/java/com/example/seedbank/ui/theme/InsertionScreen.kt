package com.example.seedbank.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.seedbank.SeedBankScreen

@Composable
fun InsertionScreen(
    navController: NavController,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
    ) {
        Text("Hello")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { navController.navigate(SeedBankScreen.Start.name) }
            ) {
                Text("Home")
            }
            Button(
                onClick = { navController.navigate(SeedBankScreen.ImageLogs.name) }
            ) {
                Text("Press Me")
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun InsertionScreenPreview() {
    SeedBankTheme {
    }
}