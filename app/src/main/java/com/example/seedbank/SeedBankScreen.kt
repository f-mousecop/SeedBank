@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.seedbank

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.seedbank.ui.theme.HomeScreen
import com.example.seedbank.ui.theme.ImageLogsScreen
import com.example.seedbank.ui.theme.InsertionScreen
import com.example.seedbank.ui.theme.SeedBankTheme
import kotlinx.coroutines.launch

enum class SeedBankScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    ImageLogs(title = R.string.image_bank),
    Insertion(title = R.string.insert_new),
    PlantLogs(title = R.string.plant_log)
}

@Composable
fun SeedBankAppBar(
    currentScreen: SeedBankScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
    ) { TopAppBar(
            title = { Text(stringResource(currentScreen.title)) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if(canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun SeedBankApp(
//    viewModel: ViewModel,
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get name of current screen
    val currentScreen = SeedBankScreen.valueOf(
        backStackEntry?.destination?.route ?: SeedBankScreen.Start.name
    )

    Scaffold(
        topBar = {
            SeedBankAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        }
    ) { innerPadding ->
//        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = SeedBankScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
        ) {
            composable(route = SeedBankScreen.Start.name) {
                HomeScreen(
                    navController = navController
                    /*onNextButtonClicked = {
                        navController.navigate(SeedBankScreen.ImageLogs.name)
                    },*/
                )
            }

            composable(route = SeedBankScreen.Insertion.name) {
                InsertionScreen(
                    navController = navController,
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(route = SeedBankScreen.ImageLogs.name) {
                val context = LocalContext.current
                ImageLogsScreen(
                    navController = navController,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}