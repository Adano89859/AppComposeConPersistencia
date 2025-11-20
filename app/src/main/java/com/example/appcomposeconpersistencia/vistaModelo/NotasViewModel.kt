package com.example.appcomposeconpersistencia.vistaModelo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcomposeconpersistencia.modelo.Nota
import com.example.appcomposeconpersistencia.repository.NotaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NotasViewModel(
    private val repository: NotaRepository
) : ViewModel() {

    // Estado de la UI: lista de notas y los campos de la nueva nota
    private val _uiState = MutableStateFlow(NotasUiState())
    val uiState: StateFlow<NotasUiState> = _uiState

    // Inicializar las notas y observar cambios en el repositorio
    init {
        viewModelScope.launch {
            repository.obtenerNotas().collect { lista ->
                _uiState.update { it.copy(notas = lista) }
            }
        }
    }

    // Funciones para cambiar el estado de los campos de la nueva nota
    fun onTituloChange(value: String) {
        _uiState.update { it.copy(tituloNuevo = value) }
    }

    fun onTextoChange(value: String) {
        _uiState.update { it.copy(textoNuevo = value) }
    }

    fun onFechaMaximaChange(value: Long) {
        _uiState.update { it.copy(fechaMaximaNuevo = value) }
    }

    fun onUrgenteChange(value: Boolean) {
        _uiState.update { it.copy(urgenteNuevo = value) }
    }

    // Función para agregar una nueva nota
    fun agregarNota() {
        viewModelScope.launch {
            if (_uiState.value.tituloNuevo.isNotBlank() && _uiState.value.textoNuevo.isNotBlank()) {
                val nuevaNota = Nota(
                    id = 0, // El ID será generado por Room de forma automática
                    titulo = _uiState.value.tituloNuevo,
                    texto = _uiState.value.textoNuevo,
                    fechaMaximaRealizacion = _uiState.value.fechaMaximaNuevo,
                    urgente = _uiState.value.urgenteNuevo
                )
                repository.insertar(nuevaNota)
                _uiState.update {
                    it.copy(tituloNuevo = "", textoNuevo = "", fechaMaximaNuevo = 0L, urgenteNuevo = false)
                }
            }
        }
    }

    // Función para borrar una nota
    fun borrarNota(nota: Nota) {
        viewModelScope.launch {
            repository.borrar(nota)
        }
    }

    // Función para cambiar el estado de urgente
    fun alternarUrgente(nota: Nota) {
        viewModelScope.launch {
            val nuevaNota = nota.copy(urgente = !nota.urgente)
            repository.editar(nuevaNota)
        }
    }
}

// Estado de la UI para gestionar los campos y lista de notas
data class NotasUiState(
    val notas: List<Nota> = emptyList(),
    val tituloNuevo: String = "",
    val textoNuevo: String = "",
    val fechaMaximaNuevo: Long = 0L,
    val urgenteNuevo: Boolean = false
)