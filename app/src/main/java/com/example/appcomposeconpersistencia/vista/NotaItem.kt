package com.example.appcomposeconpersistencia.vista

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.appcomposeconpersistencia.modelo.Nota
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private val Icons.Filled.StarBorder: ImageVector

@Composable
fun NotaItem(
    nota: Nota,
    onUrgenteClick: () -> Unit,
    onBorrarClick: () -> Unit
) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {

            // Columna para el contenido de la nota
            Column(Modifier.weight(1f)) {
                Text(nota.titulo, style = MaterialTheme.typography.h6)
                Text(nota.texto, style = MaterialTheme.typography.body2)
                Text("Fecha límite: ${formatFecha(nota.fechaMaximaRealizacion)}", style = MaterialTheme.typography.body2)
            }

            // Botón para marcar como urgente
            IconButton(onClick = onUrgenteClick) {
                Icon(
                    imageVector = if (nota.urgente) Icons.Default.Star else Icons.Default.StarBorder,
                    contentDescription = "Urgente"
                )
            }

            // Botón para borrar la nota
            IconButton(onClick = onBorrarClick) {
                Icon(Icons.Default.Delete, contentDescription = "Borrar")
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
