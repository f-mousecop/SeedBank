package com.example.seedbank.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.seedbank.ui.theme.SeedBankTheme

@Composable
fun InsertionScreen(
    dataViewModel: DataViewModel,
    navController: NavController,
    onItemClick: () -> Unit,
    viewModel: PlantEntryViewModel = viewModel(factory = AppViewModelProvider.Factory),
    modifier: Modifier
) {
    val plantList = dataViewModel.plantList
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.secondaryContainer),

        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {

            Text(
                text = "Add new plant",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
//            AddPlantInput(onPlantAdded = { dataViewModel.addPlant(it) })
            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider()
            /*PlantList(
                plantList = plantList,
                onPlantToggled = dataViewModel::togglePlant,
                onPlantDeleted = dataViewModel::deletePlant
            )*/

            Spacer(modifier = Modifier.height(16.dp))
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Need to add any new seeds?",
                modifier = Modifier,
            )
            Button(
                modifier = Modifier,
                onClick = onItemClick
            ) {
                Text(
                    text = "Seed Insert"
                )
            }
        }
    }
    /*Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
    ) {
        AddPlantInput(onPlantAdded = { dataViewModel.addPlant(it) })
        PlantList(
            plantList = plantList,
            onPlantToggled = dataViewModel::togglePlant,
            onPlantDeleted = dataViewModel::deletePlant
        )
    }*/
    /*AddSeedInput(onSeedAdded = { dataViewModel.addSeed(it) })
    SeedList(
        seedList = seedList,
        onSeedDeleted = dataViewModel::deleteSeed
    )*/
}

/*@Composable
fun AddItemInput(
    label: String,
    onItemAdded: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(label) },
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {
                if(text.isNotBlank()) {
                    onItemAdded(text)
                    text = ""
                }
            },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("Add")
        }
    }
}*/


/*@Composable
fun AddPlantInput(onPlantAdded: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            label = { Text("Common plant name")},
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .widthIn(max = 240.dp)
                .shadow(elevation = 5.dp, shape = CircleShape)
        )
        Spacer(Modifier.width(20.dp))
        Button(
            shape = RoundedCornerShape(40),
            onClick = {
            if(text.isNotBlank()) {
                onPlantAdded(text)
                text = ""
            }
        }) {
            Text("Add")
        }
    }
}*/

/*@Composable
fun AddSeedInput(onSeedAdded: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    Row {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.weight(1f)
        )
        Button(onClick = {
            if(text.isNotBlank()) {
                onSeedAdded(text)
                text = ""
            }
        }) {
            Text("Add")
        }
    }
}*/

/*@Composable
fun PlantList(
    plantList: List<PlantData>,
    onPlantToggled: (Int) -> Unit,
    onPlantDeleted: (Int) -> Unit,
) {
    LazyColumn(){
        items(plantList) { plant ->
            PlantItemRow(plant, onPlantToggled, onPlantDeleted)
        }
    }*/
    /*LazyColumn() {
        items(seedList) { seed ->
            SeedItemRow(seed, onSeedDeleted)
        }
    }*/
//}


/*@Composable
fun PlantItemRow(plant: PlantData,
                 onPlantToggled: (Int) -> Unit,
                 onPlantDeleted: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .clickable { onPlantToggled(plant.id) }
    ) {
        Checkbox(checked = plant.isHealthy, onCheckedChange = { onPlantToggled(plant.id) })
        Text(
            text = plant.text,
            modifier = Modifier.weight(1f),
            textDecoration = if(plant.isHealthy) TextDecoration.LineThrough else null
        )
        IconButton(onClick = { onPlantDeleted(plant.id) }) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete")
        }
    }
}*/


/*
@Preview (showBackground = true)
@Composable
fun InsertionScreenPreview() {
    SeedBankTheme {
        InsertionScreen(
            dataViewModel = DataViewModel(),
            navController = rememberNavController(),
            onItemClick = { },
            modifier = Modifier
        )
    }
}*/
