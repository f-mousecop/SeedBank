package com.example.seedbank.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.seedbank.R
import com.example.seedbank.ui.theme.SeedBankTheme

@Composable
fun ImageLogsScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {

        Column(
            modifier = modifier
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Card(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                Image(
                    modifier = Modifier
                        .size(300.dp),
                    painter = painterResource(imageResource),
                    contentDescription = result.toString(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = plantName,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
//            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    println("Clicked back")
                    if (result > 1) result-- },
                modifier = Modifier
                    .widthIn(100.dp)
            ) {
                Text(stringResource(R.string.previous))
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    println("Clicked next")
                    if (result < 3) result++ else result = 1 },
                modifier = Modifier
                    .widthIn(100.dp)
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ImageLogsPreview() {
    SeedBankTheme {

    }
}