package org.ies.myapp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

import org.ies.myapp.data.model.Book

class BookViewModel : ViewModel(){
    private var _books by mutableStateOf(emptyList<Book>())
    val books: List<Book> get() = _books

    init {
        _books = listOf(
            Book("El señor de los anillos", 1, "Pepe"),
            Book("El hobbit", 2, "Pedro"),
            Book("Crimen y castigo", 3, "Juan"),
            Book("Cien años de soledad", 4, "Jose")
        )
    }
    fun toggleBookExpanded(bookId: Int) {
        _books = _books.map { book ->
            if (book.isbn == bookId) {
                book.copy(isChecked = !book.isChecked)
            } else {
                book
            }
        }
    }
}