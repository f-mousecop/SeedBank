package com.example.seedbank.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seedbank.R
import com.example.seedbank.data.TodoNote
import com.example.seedbank.ui.theme.SeedBankTheme

@Composable
fun TODOScreen(
    todoViewModel: TodoViewModel = viewModel(factory = AppViewModelProvider.Factory),
    modifier: Modifier = Modifier
) {
    val notes by todoViewModel.allNotes.collectAsState(initial = emptyList())

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        TODOScreenBody(
            todoList = notes,
            onAddClick = { note -> todoViewModel.addNote(note) },
            onDeleteClick = { note -> todoViewModel.removeNote(note) },
            onToggleComplete = { note -> todoViewModel.toggleNoteCompletion(note) },
            modifier = modifier
                .fillMaxSize(),
            contentPadding = innerPadding
        )
    }
}

@Composable
private fun TODOScreenBody(
    todoList: List<TodoNote>,
    onAddClick: (String) -> Unit,
    onDeleteClick: (TodoNote) -> Unit,
    onToggleComplete: (TodoNote) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        TODOList(
            todoList = todoList,
            onAddClick = onAddClick,
            onDeleteClick = onDeleteClick,
            onToggleComplete = onToggleComplete,
            contentPadding = contentPadding,
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.padding_small))
        )
    }
}

@Composable
private fun TODOList(
    todoList: List<TodoNote>,
    onAddClick: (String) -> Unit,
    onDeleteClick: (TodoNote) -> Unit,
    onToggleComplete: (TodoNote) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    var newNote by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Text("TODOs", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = newNote,
            onValueChange = { newNote = it },
            label = { Text("Enter new TODO") },
            modifier = Modifier
                .fillMaxWidth()
        )

        Button(
            onClick = {
                if(newNote.isNotBlank()) {
                    onAddClick(newNote)
                    newNote = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add")
        }

        HorizontalDivider(Modifier.padding(vertical = 8.dp))
    }

    if(todoList.isEmpty()) {
        Text(
            text = "Add a Note",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(contentPadding)
        )
    }

    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items = todoList, key = { it.id }) { note ->
            NoteItem(
                note = note,
                onDeleteClick = onDeleteClick,
                onToggleComplete = onToggleComplete,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}

@Composable
private fun NoteItem(
    note: TodoNote,
    onDeleteClick: (TodoNote) -> Unit,
    onToggleComplete: (TodoNote) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = note.completed,
                    onCheckedChange = { onToggleComplete(note) }
                )

                val baseStyle = LocalTextStyle.current

                Text(
                    text = note.content,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = dimensionResource(R.dimen.padding_small)),
                    style = baseStyle.copy(
                        textDecoration = if(note.completed) TextDecoration.LineThrough
                        else
                            TextDecoration.None
                    )

                )


                IconButton(
                    onClick = { onDeleteClick(note) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
            }

            HorizontalDivider()
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Saved: ${java.util.Date(note.timestamp)}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
            Spacer(Modifier.height(12.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TODOScreenBodyPreview() {
    SeedBankTheme {
        TODOScreenBody(listOf(
            TodoNote(1, "This is a test, testing sdjaskdaklsdjlaksdkasjdkalskdaksdjlkasjd", System.currentTimeMillis())
        ),  onAddClick = {}, onDeleteClick = {}, onToggleComplete = {})
    }
}