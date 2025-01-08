@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.seedbank

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.seedbank.ui.DataViewModel
import com.example.seedbank.ui.theme.SeedBankTheme


@Composable
fun SeedBankApp() {
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get name of current screen
    val currentScreen = SeedBankScreen.valueOf(
        backStackEntry?.destination?.route ?: SeedBankScreen.Start.name
    )

    val dataViewModel = viewModel<DataViewModel>()

    DetailedNavDrawer(
        navController = navController,
        currentScreen = currentScreen
    )
}

@Preview (showBackground = true)
@Composable
private fun SeedAppPreview() {
    SeedBankTheme {
        SeedBankApp()
    }
}