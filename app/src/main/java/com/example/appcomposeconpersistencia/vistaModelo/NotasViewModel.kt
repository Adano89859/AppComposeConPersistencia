package com.example.appcomposeconpersistencia.vistaModelo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcomposeconpersistencia.modelo.Nota
import com.example.appcomposeconpersistencia.modelo.NotaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


//Clase que se encarga de gestionar el estado y la lógica de las notas
class NotasViewModel(
    //Se proporciona acceso a la base de datos
    private val repository: NotaRepository
) : ViewModel() {

    // Estado mutable de la UI, solo modificable desde el ViewModel
    private val _uiState = MutableStateFlow(NotasUiState())

    // Estado público de solo lectura para la UI
    val uiState: StateFlow<NotasUiState> = _uiState

    //Inicializa el ViewModel y comienza a observar los cambios de las notas
    init {
        //Cada vez que surjan cambios en la BD la UI se actualizará automáticamente
        viewModelScope.launch {
            repository.obtenerNotas().collect { listaNotas ->
                _uiState.update { estadoActual ->
                    estadoActual.copy(notas = listaNotas)
                }
            }
        }
    }

    // ========== FUNCIONES PARA ACTUALIZAR CAMPOS DEL FORMULARIO ==========

    //Función para actualizar el título de la nueva nota en el estado
    fun onTituloChange(value: String) {
        _uiState.update { estadoActual ->
            estadoActual.copy(tituloNuevo = value)
        }
    }


    //Función para actualizar el texto en la nueva nota en el estado
    fun onTextoChange(value: String) {
        _uiState.update { estadoActual ->
            estadoActual.copy(textoNuevo = value)
        }
    }

    //Función para actualizar la fecha máxima de la realización de la nota
    fun onFechaMaximaChange(value: Long) {
        _uiState.update { estadoActual ->
            estadoActual.copy(fechaMaximaNuevo = value)
        }
    }

    //Función que actualiza el estado de urgencia de la nueva nota
    fun onUrgenteChange(value: Boolean) {
        _uiState.update { estadoActual ->
            estadoActual.copy(urgenteNuevo = value)
        }
    }

    // ========== FUNCIONES PARA OPERACIONES CRUD ==========


    //Función que valida que el título y el texto no estén vacíos antes de insertar
    fun agregarNota() {
        viewModelScope.launch {
            val estadoActual = _uiState.value
            // Validar que los campos obligatorios no estén vacíos
            if (estadoActual.tituloNuevo.isNotBlank() && estadoActual.textoNuevo.isNotBlank()) {
                val nuevaNota = Nota(
                    id = 0, // El ID será generado automáticamente por Room
                    titulo = estadoActual.tituloNuevo.trim(),
                    texto = estadoActual.textoNuevo.trim(),
                    fechaMaximaRealizacion = estadoActual.fechaMaximaNuevo,
                    urgente = estadoActual.urgenteNuevo
                )
                // Insertar la nueva nota en la base de datos
                repository.insertar(nuevaNota)

                // Limpiar el formulario después de agregar una vez la inserción sea exitosa
                _uiState.update {
                    it.copy(
                        tituloNuevo = "",
                        textoNuevo = "",
                        fechaMaximaNuevo = 0L,
                        urgenteNuevo = false
                    )
                }
            }
        }
    }

    //Función que elimina la nota seleccionada
    fun borrarNota(nota: Nota) {
        viewModelScope.launch {
            repository.borrar(nota)
        }
    }


    //Función para alternar el estado de urgencia
    fun alternarUrgente(nota: Nota) {
        viewModelScope.launch {
            // Crear una copia de la nota con el estado de urgencia invertido
            val notaActualizada = nota.copy(urgente = !nota.urgente)
            // Actualizar la nota en la base de datos
            repository.editar(notaActualizada)
        }
    }
}

//Estado de la UI para la pantalla de notas
data class NotasUiState(
    val notas: List<Nota> = emptyList(),
    val tituloNuevo: String = "",
    val textoNuevo: String = "",
    val fechaMaximaNuevo: Long = 0L,
    val urgenteNuevo: Boolean = false
)