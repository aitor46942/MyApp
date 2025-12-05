package org.ies.myapp.presentation.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ies.myapp.data.model.Book

@Composable
fun BooksScreen(){
    val bookList = listOf(
        Book("El señor de los anillos", 1, "Pepe"),
        Book("El hobbit", 2, "Pedro"),
        Book("Crimen y castigo", 3, "Juan"),
        Book("Cien años de soledad", 4, "Lorenzo"),
    )
    Scaffold { innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){
            LazyColumn {
                items(bookList) {book ->
                    var isExpanded by remember { mutableStateOf(false) }
                    Column (modifier = Modifier.padding(16.dp)){
                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable{isExpanded = !isExpanded},
                            shape = RectangleShape
                        ){
                            Column (
                                modifier = Modifier
                                    .padding(16.dp)
                                    .animateContentSize()
                            ){
                                Text(
                                    text = book.title,
                                    fontWeight = FontWeight.Bold
                                )
                                if (isExpanded) {
                                    Text(
                                        text = "ISBN: ${book.isbn}",
                                        )
                                    Text(
                                        text = "Autor:  ${book.autor}"
                                    )
                                    Icon(
                                        imageVector = Icons.Default.Book,
                                        contentDescription = "Icono de libro"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BooksPreview(){
    BooksScreen()
}