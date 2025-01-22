package com.example.seedbank.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.seedbank.R
import com.example.seedbank.data.Plant
import com.example.seedbank.ui.theme.SeedBankTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantBankScreen(
    navController: NavController,
    navigateToItemEntry: () -> Unit,
    navigateToItemUpdate: (Int) -> Unit,
    navigateBack: () -> Unit,
    canNavigateBack: Boolean = true,
    modifier: Modifier = Modifier,
    viewModel: PlantBankViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val plantBankUiState by viewModel.plantBankUiState.collectAsState()
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier,
        /*topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.plant_bank)) },
                modifier = Modifier,
                navigationIcon = {
                    if(canNavigateBack) {
                        IconButton(onClick = navigateBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.back_button)
                            )
                        }
                    }
                }
            )
        }*/
    ) { innerPadding ->
        PlantBankBody(
            plantList = plantBankUiState.plantList,
            onItemClick = navigateToItemUpdate,
            onDeleteClick = { plant -> viewModel.deletePlant(plant) },
            modifier = modifier
                .fillMaxSize(),
            contentPadding = innerPadding
        )
    }
}

@Composable
private fun PlantBankBody(
    plantList: List<Plant>,
    onItemClick: (Int) -> Unit,
    onDeleteClick: (Plant) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        if(plantList.isEmpty()) {
            Text(
                text = stringResource(R.string.no_plant_description),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(contentPadding)
            )
        } else {
            PlantList(
                plantList = plantList,
                onItemClick = { onItemClick(it.id) },
                onDeleteClick = onDeleteClick,
                contentPadding = contentPadding,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
private fun PlantList(
    plantList: List<Plant>,
    onItemClick: (Plant) -> Unit,
    onDeleteClick: (Plant) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items = plantList, key = { it.id }) { plant ->
            BankItem(
                plant = plant,
                onDeleteClick = onDeleteClick,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clickable { onItemClick(plant) }
            )
        }
    }
}

@Composable
private fun BankItem(
    plant: Plant,
    onDeleteClick: (Plant) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(
                    text = plant.name,
                    style = MaterialTheme.typography.titleLarge,
                )
//                Spacer(Modifier.weight(1f))
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = plant.species,
                    style = MaterialTheme.typography.titleMedium,
                    fontStyle = FontStyle.Italic
                )
            }
            Text(
                text = plant.type,
                style = MaterialTheme.typography.titleMedium
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_extra_large)),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = plant.growthTime,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = plant.quantity.toString(),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.weight(1f))
                IconButton(
                    onClick = { onDeleteClick(plant) }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlantBankBodyPreview(){
    SeedBankTheme {
        PlantBankBody(listOf(
            Plant(1, "Hello", "d", "o", "2.0",  1)
        ), onItemClick = {}, onDeleteClick = {})
    }
}