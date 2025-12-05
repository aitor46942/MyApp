package org.ies.myapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import org.ies.myapp.data.model.Book

class BookViewModel : ViewModel(){
    private val _books = mutableStateListOf<Book>()

    val book: List<Book> get() = _books

    init {
        _books.add(Book("El señor de los anillos", 1, "Pepe"))
    }
}