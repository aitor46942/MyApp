package org.ies.myapp.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ies.myapp.presentation.viewmodel.LazyColumnViewModel

@Composable
fun LazyColumna (viewModel: LazyColumnViewModel = viewModel()) {
    val itemList = viewModel.items
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Text("Este es un BottomBar")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Scaffold Demo",
                fontSize = 24.sp
            )
            LazyColumn {
                itemsIndexed(itemList) { index, item ->

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Mail,
                            contentDescription = "Mail icon"
                        )

                        Checkbox(
                            checked = item.isChecked,
                            onCheckedChange = {
                                viewModel.onCheckedChange(index, it)
                            }
                        )

                        Text(
                            text = item.title,
                            modifier = Modifier.padding(start = 16.dp)
                        )
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