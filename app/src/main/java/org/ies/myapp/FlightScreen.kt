package org.ies.myapp

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FlightScreen(){
    val options = listOf("Regular", "Charter")
    var selectedOption by remember { mutableStateOf(options[0]) }
    var numVuelo by remember { mutableStateOf("") }
    var origen by remember { mutableStateOf("") }
    var destino by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var number by remember { mutableIntStateOf(0) }
        Scaffold { innerPadding ->
            Column (
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ){
                Column {

                    OutlinedTextField(
                        value = numVuelo,
                        onValueChange = {newText -> numVuelo = newText},
                        label = { Text("Número de vuelo") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        OutlinedTextField(
                            value = origen,
                            onValueChange = {newText -> origen = newText},
                            label = { Text("Origen") },
                            modifier = Modifier.width(180.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        OutlinedTextField(
                            value = destino,
                            onValueChange = {newText -> destino = newText},
                            label = { Text("Destino") },
                            modifier = Modifier.width(180.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = number.toString(),
                        label = {Text("Precio")},
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = { newText ->
                            number = if (newText.isBlank()) 0 else newText.toIntOrNull() ?: number
                        })
                }

                Column {
                    Text("Tipo de vuelo")
                    options.forEach { option ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = (option == selectedOption),
                                onClick = { selectedOption = option }
                            )
                            Text(
                                text = option,
                                modifier = Modifier.clickable { selectedOption = option }
                            )
                        }
                    }
                }
                Column {
                    OutlinedTextField(
                        value = descripcion,
                        onValueChange = {newText -> descripcion = newText},
                        label = {Text("Descripción")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(450.dp)
                    )
                }
                Column (
                    modifier = Modifier.fillMaxSize()
                ){
                    if (!numVuelo.isEmpty() && !origen.isEmpty() && !destino.isEmpty()) {
                        Button(
                            onClick = {}, enabled = true,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text("Aceptar")
                        }
                    }else{
                        Button(
                            onClick = {}, enabled = false,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text("Aceptar")
                        }
                    }
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun FlightScreenPreview() {
    FlightScreen()
}