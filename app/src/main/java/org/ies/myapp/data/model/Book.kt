package org.ies.myapp.data.model

data class Book(
    val title: String,
    val isbn: Int,
    val author: String,
    val isChecked: Boolean = false
)
