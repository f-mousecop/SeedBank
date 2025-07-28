package com.example.seedbank.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.seedbank.R
import com.example.seedbank.ui.theme.SeedBankTheme

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(
            modifier = Modifier.align(alignment = Alignment.Center)
        ) {
            Text(
                text =  "Welcome to",
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
            )

            Image(
                painter = painterResource(R.drawable.picture2),
                modifier = Modifier
                    .size(350.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.FillHeight,
                contentDescription = null
            )
        }
    }
}
@Preview (showBackground = true)
@Composable
fun HomeScreenPreview() {
    SeedBankTheme {
        HomeScreen(
            navController = rememberNavController(),
            modifier = Modifier
        )
    }
}