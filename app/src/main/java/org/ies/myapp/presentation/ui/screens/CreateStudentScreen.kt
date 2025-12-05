package org.ies.myapp.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ies.myapp.presentation.viewmodel.CreateStudentScreenViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateStudentScreen(createStudentScreenViewModel: CreateStudentScreenViewModel = viewModel()) {
    val student by createStudentScreenViewModel.student.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Crear estudiante")

                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(8.dp)
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = student.edad.toString(),
                // Modificamos el teclado del usuario de forma que solo haya números
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                // La lambda se encarga de evitar que meta letras en el campo
                onValueChange = { newText ->
                    createStudentScreenViewModel.setEdad(
                        if (newText.isBlank()) 0 else newText.toIntOrNull() ?: student.edad
                    )
                }
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = student.nombre,
                label = {
                    Text("Nombre")
                },
                onValueChange = { createStudentScreenViewModel.setNombre(it) }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = student.apellidos,
                label = {
                    Text("Apellidos")
                },
                onValueChange = { createStudentScreenViewModel.setApellidos(it) }
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = student.nif,
                label = {
                    Text("Nif")
                },
                onValueChange = { createStudentScreenViewModel.setNif(it) }
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        createStudentScreenViewModel.clear()
                    }
                ) {
                    Text("Limpiar")
                }
                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = {

                }) {
                    Text("Aceptar")
                }
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun CreateStudentScreenPreview() {
    CreateStudentScreen()
}