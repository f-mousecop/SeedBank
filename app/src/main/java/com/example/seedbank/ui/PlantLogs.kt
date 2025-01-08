package com.example.seedbank.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.seedbank.R
import com.example.seedbank.model.Plant

@Composable
fun PlantCard(
    plant: Plant,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier) {
    Card(modifier = modifier.background(MaterialTheme.colorScheme.secondaryContainer)) {
        Column {
            Image(
                painter = painterResource(plant.imageResourceId),
                contentDescription = stringResource(plant.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .clickable(
                        enabled = true,
                        onClickLabel = stringResource(plant.stringResourceId),
                    ) {
                        Log.d("Userplantlogsscreen", "ButtonClicked")
                        onItemClick()
                    },
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(plant.stringResourceId),
                modifier = Modifier
                    .padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun PlantList(
    plantList: List<Plant>,
    navController: NavController,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(plantList) { plant ->
            PlantCard(
                plant = plant,
                onItemClick = onItemClick,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun PlantLogPreview() {
    PlantCard(
        Plant(R.string.arrowhead_plant, R.drawable.arrowhead_plant),
        onItemClick = {})
}