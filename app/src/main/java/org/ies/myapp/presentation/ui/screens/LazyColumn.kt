package org.ies.myapp.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//Hola
@Composable
fun LazyColumna (){
    val itemList = List(20) {"Item $it"}
    var isChecked by remember { mutableStateOf(false) }
    Scaffold (
        bottomBar = {
            BottomAppBar {
                Text("Este es un BottomBar")
            }
        }
    ){ innerPadding ->
        Column (modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
            .fillMaxSize()){
            Text(
                text = "Scaffold Demo",
                fontSize = 24.sp)
            LazyColumn {
                items(itemList) { item ->
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = Icons.Filled.Mail,
                            contentDescription = "Mail icon "
                        )
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it }
                        )
                        Text(text = item, modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnaPreview() {
    LazyColumna()
}