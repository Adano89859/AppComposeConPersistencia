package com.example.appcomposeconpersistencia.vista

//Imports necesarios
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appcomposeconpersistencia.vistaModelo.NotasViewModel

//Pantalla principal que muestra la lista de notas o el formulario
@Composable
fun NotasScreen(
    viewModel: NotasViewModel
) {
    //Guardamos en esta variable el estado de la UI del viewModel
    val uiState = viewModel.uiState.collectAsState().value

    //Uso de IF para mostrar el formulario o la lista de notas según el estado
    if (uiState.mostrarFormulario) {
        // Pantalla de agregar nota
        PantallaAgregarNota(viewModel)
    } else {
        // Pantalla principal con lista
        PantallaListaNotas(viewModel)
    }
}

// Pantalla principal con lista de notas
@Composable
fun PantallaListaNotas(
    viewModel: NotasViewModel
) {
    val uiState = viewModel.uiState.collectAsState().value

    Scaffold(
        floatingActionButton = {
            //Botón para agregar una nueva nota
            FloatingActionButton(
                onClick = { viewModel.mostrarFormulario() }
            ) {
                androidx.compose.material3.Icon(
                    Icons.Default.Add,
                    contentDescription = "Agregar nota"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            //Título de la pantalla
            Text("Lista de Notas", style = MaterialTheme.typography.headlineMedium)

            //Espaciador para separar el título de la lista
            Spacer(Modifier.height(12.dp))

            //Subtítulo para la lista
            Text("Tus Notas:", style = MaterialTheme.typography.titleMedium)

            //Espaciador para separar el subtítulo de la lista
            Spacer(Modifier.height(8.dp))

            //Uso de LazyColumn para renderizar los elementos visibles
            //Lo usamos el LazyColumn sobretodo para tratar con listas largas ya que no renderiza todo a la vez
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                //Itera cada nota que se encuentre dentro
                items(uiState.notas) { nota ->
                    //Componente individual para cada nota
                    NotaItem(
                        nota = nota,
                        onUrgenteClick = { viewModel.alternarUrgente(nota) }, //Al hacer click, se alterna el estado de urgencia
                        onBorrarClick = { viewModel.borrarNota(nota) }, //Al hacer click, se borra la nota creada
                        onEditarClick = { viewModel.iniciarEdicion(nota) }
                    )
                }
            }
        }
    }
}

//Pantalla para agregar nueva nota
@Composable
fun PantallaAgregarNota(
    viewModel: NotasViewModel
) {
    val uiState = viewModel.uiState.collectAsState().value

    Scaffold(
        floatingActionButton = {
            //Botón para volver a la lista
            FloatingActionButton(
                onClick = {
                    if (uiState.esModoEdicion) {
                        viewModel.cancelarEdicion()
                    } else {
                        viewModel.ocultarFormulario()
                    }
                }
            ) {
                androidx.compose.material3.Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Volver a la lista"
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            //Formulario para agregar nuevas notas
            FormularioNota(
                titulo = uiState.tituloNuevo,
                texto = uiState.textoNuevo,
                fechaMaxima = uiState.fechaMaximaNuevo,
                urgente = uiState.urgenteNuevo,
                esModoEdicion = uiState.esModoEdicion,
                onTituloChange = viewModel::onTituloChange,
                onTextoChange = viewModel::onTextoChange,
                onFechaMaximaChange = viewModel::onFechaMaximaChange,
                onUrgenteChange = viewModel::onUrgenteChange,
                onAgregarNota = viewModel::agregarNota, //Aquí se agrega y se cierra la nota una vez creada
                onActualizarNota = viewModel::actualizarNota
            )
        }
    }
}