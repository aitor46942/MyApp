package org.ies.myapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

import org.ies.myapp.data.model.Book

class BookViewModel : ViewModel(){
    private val _books = MutableStateFlow(
        listOf(
            Book("El señor de los anillos", 1, "Pepe"),
            Book("El hobbit", 2, "Pedro"),
            Book("Crimen y castigo", 3, "Juan"),
            Book("Cien años de soledad", 4, "Jose")
        )
    )
    val books: StateFlow<List<Book>> = _books
    fun toggleBookExpanded(bookId: Int) {
        _books.update { currentList ->
            currentList.map { book ->
                if (book.isbn == bookId) {
                    book.copy(isChecked = !book.isChecked)
                }else{
                    book
                }
            }
        }
    }
}