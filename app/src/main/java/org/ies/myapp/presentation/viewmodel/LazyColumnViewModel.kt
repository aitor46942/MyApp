package org.ies.myapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import org.ies.myapp.data.model.Item

class LazyColumnViewModel : ViewModel() {
    private val _items = mutableStateListOf<Item>()

    val items: List<Item> get() = _items

    init {
        repeat(20){
            _items.add(Item(title = "Item $it"))
        }
    }

    fun onCheckedChange(index: Int, checked: Boolean) {
        _items[index] = _items[index].copy(isChecked = checked)
    }
}