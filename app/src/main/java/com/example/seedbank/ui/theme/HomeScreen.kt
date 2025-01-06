package com.example.seedbank.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.example.seedbank.SeedBankScreen

@Composable
fun HomeScreen(
    navController: NavController,
//    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
    ) {
        Text("Hello")
        Button(
            onClick = { navController.navigate(SeedBankScreen.Insertion.name) }
        ) {
            Text("Press Me") }
    }
}
@Preview
@Composable
fun HomeScreenPreview() {
    SeedBankTheme {
    }
}