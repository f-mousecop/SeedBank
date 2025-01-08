@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.seedbank

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.seedbank.ui.theme.SeedBankTheme
import kotlinx.coroutines.launch


@Composable
fun DetailedNavDrawer(
//    content: @Composable (PaddingValues) -> Unit
    onItemClick: () -> Unit = {},
    navController: NavHostController,
    currentScreen: SeedBankScreen
) {
//    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val snackbarHostState = remember { SnackbarHostState() }
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get name of current screen
    /*val currentScreen = SeedBankScreen.valueOf(
        backStackEntry?.destination?.route ?: SeedBankScreen.Start.name
    )*/

    val layoutDirection = LocalLayoutDirection.current

    ModalNavigationDrawer(
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Seed Bank Menu",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleLarge)

                    NavigationDrawerItem(
                        label = { Text("Home") },
                        selected = false,
                        icon = { Icon(Icons.Default.Home, contentDescription = null)},
                        badge = { Text("20")},
                        onClick =  {
                            println("hello")
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(SeedBankScreen.Start.name) {
                                popUpTo(0)
                            }
                        }
                    )

                    NavigationDrawerItem(
                        label = { Text("Log Plant") },
                        selected = false,
                        icon = { Icon(Icons.Default.Add, contentDescription = null)},
                        onClick =  {
                            println("Logs")
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(SeedBankScreen.Insertion.name) {
                                popUpTo(0)
                            }
                        }
                    )

                    NavigationDrawerItem(
                        label = { Text("Add Seeds") },
                        selected = false,
                        icon = { Icon(Icons.Default.Add, contentDescription = null)},
                        onClick =  {
                            println("Seeds")
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(SeedBankScreen.Seeds.name) {
                                popUpTo(0)
                            }
                        }
                    )

                    NavigationDrawerItem(
                        label = { Text("Image Logs") },
                        selected = false,
                        icon = { Icon(Icons.Default.Info, contentDescription = null)},
                        onClick =  {
                            println("Images")
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(SeedBankScreen.ImageLogs.name) {
                                popUpTo(0)
                            }
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text("Plant Logs") },
                        selected = false,
                        icon = { Icon(Icons.Default.Info, contentDescription = null)},
                        onClick =  {
                            println("Plants")
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(SeedBankScreen.PlantLogs.name) {
                                popUpTo(0)
                            }
                        }
                    )
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.app_name)) },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if(drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, "Menu")
                        }
                    }
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val result = snackbarHostState
                                .showSnackbar(
                                    message = "Insert a new plant or seed entry",
                                    actionLabel = "Action",
                                    withDismissAction = true,
                                    duration = SnackbarDuration.Indefinite
                                )
                            when(result) {
                                SnackbarResult.ActionPerformed -> {
                                    println("Action performed")
                                    navController.navigate(SeedBankScreen.Insertion.name) {
                                        popUpTo(0)
                                    }
                                }
                                SnackbarResult.Dismissed -> {
                                }
                            }
                        }
                    }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            },
        ) { innerPadding ->
            ComposeNavigation(
                modifier = Modifier.padding(innerPadding),
                navController = navController
            )
        }
    }
}
@Preview (showBackground = true)
@Composable
fun NavDrawerPreview() {
    SeedBankTheme {

    }
}

