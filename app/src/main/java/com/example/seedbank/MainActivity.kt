@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.seedbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.seedbank.ui.theme.SeedBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeedBankTheme {
                SeedBankApp()
            }
        }
    }
}

@Composable
fun SeedBankLayout(content: @Composable () -> Unit) {
    var presses by remember { mutableStateOf(0) }
    val amount = presses.toString()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(innerPadding)
                .padding(horizontal = 40.dp)
                .padding(bottom = 20.dp)
//                .verticalScroll(rememberScrollState())
                .safeDrawingPadding()
        ) {
            content()
        }
    }
}

/*@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Home Screen")
        Button(onClick = { navController.navigate("details") }) {
            Text("Go to details")
        }
    }
}*/

@Composable
fun ImageCarousel(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
//    var plantName by remember { mutableStateOf("") }

    val imageResource = when (result) {
        1 -> R.drawable.arrowhead_plant
        2 -> R.drawable.cape_honeysuckle
        else -> R.drawable.zinnia
    }

    val plantName = when (result) {
        1 -> stringResource(R.string.arrowhead_plant)
        2 -> stringResource(R.string.cape_honeysuckle)
        else -> stringResource(R.string.zinnia)
    }
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            alignment = Alignment.TopCenter,
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Text(
            text = plantName,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(80.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = { if(result > 1) result-- },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(stringResource(R.string.previous))
            }
            Button(
                onClick = { if(result < 3) result++ else result = 1},
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SeedBankApp() {
    SeedBankTheme {
        SeedBankLayout(content = {
            ImageCarousel(modifier = Modifier
                .fillMaxSize()
//                .wrapContentSize(Alignment.Center)
            )
        })
    }
}