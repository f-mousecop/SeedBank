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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.seedbank.ui.theme.SeedBankTheme

@Composable
fun AddSeedsScreen(
    dataViewModel: DataViewModel,
    navController: NavController,
    modifier: Modifier
) {
    val seedList = dataViewModel.seedList
    Box(
        modifier = Modifier
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
                text = "Add new seeds",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            AddSeedInput(
                onSeedAdded = { dataViewModel.addSeed(it) }
            )
            Spacer(modifier = Modifier.height(24.dp))
            HorizontalDivider()

            SeedList(
                seedList = seedList,
                onSeedToggled = dataViewModel::toggleSeed,
                onSeedDeleted = dataViewModel::deleteSeed
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun SeedList(
    seedList: List<SeedData>,
    onSeedToggled: (Int) -> Unit,
    onSeedDeleted: (Int) -> Unit
) {
    LazyColumn {
        items(seedList) { seed ->
            SeedItemRow(seed, onSeedToggled, onSeedDeleted)
        }
    }
}

@Composable
fun SeedItemRow(
    seed: SeedData,
    onSeedToggled: (Int) -> Unit,
    onSeedDeleted: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .clickable { onSeedDeleted(seed.id) }
            .padding(vertical = 4.dp)
    ) {
        Checkbox(checked = seed.isGrowing, onCheckedChange = { onSeedToggled(seed.id) })
        Text(
            text = seed.text,
            modifier = Modifier.weight(1f),
            textDecoration = if(seed.isGrowing) TextDecoration.LineThrough else null,
            style = MaterialTheme.typography.bodyLarge
        )
        IconButton(onClick = { onSeedDeleted(seed.id) }) {
            Icon(Icons.Filled.Delete, contentDescription = "Delete")
        }
    }
}

@Composable
fun AddSeedInput(onSeedAdded: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            label = { Text("Enter the seed name")},
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
                onSeedAdded(text)
                text = ""
            }
        }) {
            Text("Add")
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun SeedScreenPreview() {
    SeedBankTheme {
        AddSeedsScreen(
            dataViewModel = DataViewModel(),
            navController = rememberNavController(),
            modifier = Modifier
        )
    }
}