package org.ies.myapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.ies.myapp.data.model.Student

class CreateStudentScreenViewModel : ViewModel() {
    private val _student = MutableStateFlow<Student>(
        Student( "", "", "",0)
    )

    val student: StateFlow<Student> = _student


    fun setEdad(edad: Int) {
        _student.value = _student.value.copy(edad = edad)
    }

    fun setNombre(nombre: String) {
        _student.value = _student.value.copy(nombre = nombre)
    }

    fun setApellidos(apellidos: String) {
        _student.value = _student.value.copy(apellidos = apellidos)
    }

    fun setNif(nif: String) {
        _student.value = _student.value.copy(nif = nif)
    }

    fun clear() {
        _student.value = Student( "", "", "",0)
    }
}