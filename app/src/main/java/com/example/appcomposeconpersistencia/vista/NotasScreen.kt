package com.example.appcomposeconpersistencia.vista

//Imports necesarios
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appcomposeconpersistencia.vistaModelo.NotasViewModel

//Pantalla principal que muestra la lista de notas
@Composable
fun NotasScreen(
    viewModel: NotasViewModel
) {
    //Guardamos en esta variable el estado de la UI del viewModel
    val uiState = viewModel.uiState.collectAsState().value //Se usa collectAsState() para convertir el StateFlow en un estado observable

    //Layout principal con su padding
    Column(Modifier.padding(16.dp)) {

        //Título de la pantalla
        Text("Lista de Notas", style = MaterialTheme.typography.headlineMedium)

        //Espaciador para separar el título de la lista
        Spacer(Modifier.height(12.dp))

        //Uso de LazyColumn para renderizar los elementos visibles
        //Lo usamos el LazyColumn sobretodo para tratar con listas largas ya que no renderiza todo a la vez
        LazyColumn {
            //Itera cada nota que se encuentre dentro
            items(uiState.notas) { nota ->
                //Componente individual para cada nota
                NotaItem(
                    nota = nota,
                    onUrgenteClick = { viewModel.alternarUrgente(nota) }, //Al hacer click, se alterna el estado de urgencia
                    onBorrarClick = { viewModel.borrarNota(nota) } //Al hacer click, se borra la nota creada
                )
            }
        }
    }
}
