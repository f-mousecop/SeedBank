package com.example.seedbank

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.seedbank.data.Datasource
import com.example.seedbank.ui.AddSeedsScreen
import com.example.seedbank.ui.DataViewModel
import com.example.seedbank.ui.HomeScreen
import com.example.seedbank.ui.ImageLogsScreen
import com.example.seedbank.ui.InsertionScreen
import com.example.seedbank.ui.PlantEntryScreen
import com.example.seedbank.ui.PlantList

enum class SeedBankScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    ImageLogs(title = R.string.image_bank),
    PlantEntry(title = R.string.plant_entry),
    Insertion(title = R.string.insert_new),
    Seeds(title = R.string.insert_seeds),
    PlantLogs(title = R.string.plant_log)
}

@Composable
fun ComposeNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
    ) {
//    val dataViewModel = viewModel<DataViewModel>()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SeedBankScreen.Start.name
    ) {
        composable(route = SeedBankScreen.Start.name) {
            HomeScreen(
                navController = navController,
                modifier = Modifier.fillMaxSize()
            )
        }

        composable(route = SeedBankScreen.PlantEntry.name) {
            PlantEntryScreen(
                navController = navController,
                navigateBack = { navController.popBackStack() },
                navigateUp = { navController.navigateUp() },
                onItemClick = { navController.navigate(SeedBankScreen.Start.name)}
            )
        }

        /*composable(route = SeedBankScreen.Insertion.name) {
            InsertionScreen(
                navController = navController,
                dataViewModel = dataViewModel,
                onItemClick = { navController.navigate(route = SeedBankScreen.Seeds.name) },
                modifier = Modifier.fillMaxSize()
            )
        }*/

        /*composable(route = SeedBankScreen.Seeds.name) {
            AddSeedsScreen(
                dataViewModel = dataViewModel,
                navController = navController,
                modifier = Modifier.fillMaxSize()
            )
        }*/

        composable(route = SeedBankScreen.ImageLogs.name) {
            ImageLogsScreen(
                navController = navController,
                modifier = Modifier.fillMaxSize()
            )
        }

        composable(route = SeedBankScreen.PlantLogs.name) {
            PlantList(
                plantList = Datasource().loadPlants(),
                navController = navController,
                onItemClick = { navController.navigate(route = SeedBankScreen.Start.name) }
            )
        }
    }
}