package org.ies.myapp.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import org.ies.myapp.presentation.viewmodel.CreateTaskViewModel


@Composable
fun CreateTaskScreen(createTaskViewModel: CreateTaskViewModel = viewModel()) {
    val task by createTaskViewModel.task.collectAsState()

    Scaffold(
        topBar = {
            Text("Crear tarea")
        }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = task.title,
                onValueChange = {
                    createTaskViewModel.setTitle(it)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = task.description,
                onValueChange = {
                    createTaskViewModel.setDescription(it)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = { createTaskViewModel.save() }
            ) {
                Text("Guardar")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CreateTaskPreview() {
    CreateTaskScreen()
}