package org.ies.myapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import org.ies.myapp.data.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CreateTaskViewModel : ViewModel() {
    // Estado mutable que almacena el listado de tareas
    private val _task = MutableStateFlow<Task>(
        Task(0, "", "")
    )
    // Version inmutable del estado anterior, es el estado que va a leer el UI
    val task: StateFlow<Task> = _task


    fun setTitle(title: String) {
        _task.value = _task.value.copy(title = title)
    }

    fun setDescription(description: String) {
        _task.value = _task.value.copy(description = description)
    }


    fun save() {
        // TODO Aquí va la lógica para guardar la tarea
        // Veremos qué se hace en el próximo tema
    }
}