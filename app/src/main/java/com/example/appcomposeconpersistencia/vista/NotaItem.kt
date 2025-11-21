package com.example.appcomposeconpersistencia.vista

//Imports necesarios
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appcomposeconpersistencia.modelo.Nota
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//Aquí se representan las notas de manera individual
@Composable
fun NotaItem(
    nota: Nota,
    onUrgenteClick: () -> Unit,
    onBorrarClick: () -> Unit
) {
    //Tarjeta que contiene toda la información de la nota
    Card(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        //Fila en donde se organiza el contenido y sus botones
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {

            // Columna para el contenido de la nota
            Column(Modifier.weight(1f)) {
                Text(nota.titulo, style = MaterialTheme.typography.titleMedium)
                Text(nota.texto, style = MaterialTheme.typography.bodyMedium)
                Text("Fecha límite: ${formatFecha(nota.fechaMaximaRealizacion)}", style = MaterialTheme.typography.bodySmall)
            }

            // Botón para marcar como urgente
            IconButton(onClick = onUrgenteClick) {
                Icon(
                    imageVector = if (nota.urgente) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = if(nota.urgente)"Quitar urgencia" else "Marcar como urgente"
                )
            }

            // Botón para borrar la nota
            IconButton(onClick = onBorrarClick) {
                Icon(Icons.Default.Delete, contentDescription = "Borrar nota")
            }
        }
    }
}

// Función auxiliar para formatear la fecha
fun formatFecha(fecha: Long): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val date = Date(fecha)
    return dateFormat.format(date)
}
