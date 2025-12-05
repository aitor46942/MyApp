package org.ies.myapp.presentation.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ies.myapp.presentation.viewmodel.BookViewModel
import androidx.compose.foundation.lazy.items


@Composable
fun BooksScreen(viewModel: BookViewModel = viewModel()){
    val books by viewModel.books.collectAsState()
    Scaffold { innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){
            LazyColumn {
                items(books, key = {book -> book.isbn}) {book ->
                    Column (modifier = Modifier.padding(16.dp)){
                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable{
                                    viewModel.toggleBookExpanded(book.isbn)
                                },
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
                                if (book.isChecked) {
                                    Text(
                                        text = "ISBN: ${book.isbn}",
                                    )
                                    Text(
                                        text = "Autor:  ${book.author}"
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