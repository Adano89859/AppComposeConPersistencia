package com.example.appcomposeconpersistencia.vista

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appcomposeconpersistencia.util.formatFecha

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioNota(
    titulo: String,
    texto: String,
    fechaMaxima: Long,
    urgente: Boolean,
    esModoEdicion: Boolean = false,
    onTituloChange: (String) -> Unit,
    onTextoChange: (String) -> Unit,
    onFechaMaximaChange: (Long) -> Unit,
    onUrgenteChange: (Boolean) -> Unit,
    onAgregarNota: () -> Unit,
    onActualizarNota: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                if (esModoEdicion) "Editar Nota" else "Agregar Nueva Nota",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(12.dp))

            // Campo para el título
            OutlinedTextField(
                value = titulo,
                onValueChange = onTituloChange,
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = { Text("Ingresa el título de la nota") }
            )

            Spacer(Modifier.height(8.dp))

            // Campo para el texto
            OutlinedTextField(
                value = texto,
                onValueChange = onTextoChange,
                label = { Text("Contenido") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Ingresa el contenido de la nota") },
                minLines = 3
            )

            Spacer(Modifier.height(8.dp))

            // Información de fecha actual
            Text(
                "Fecha límite: ${if (fechaMaxima > 0) formatFecha(fechaMaxima) else "No establecida"}",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(Modifier.height(8.dp))

            // Botones para diferentes fechas
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Fila 1 de botones
                Button(
                    onClick = {
                        onFechaMaximaChange(System.currentTimeMillis()) // Hoy
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Hoy")
                }

                Spacer(Modifier.height(4.dp))

                // Fila 2 de botones
                Button(
                    onClick = {
                        onFechaMaximaChange(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000) // 3 días
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("En 3 días")
                }

                Spacer(Modifier.height(4.dp))

                // Fila 3 de botones
                Button(
                    onClick = {
                        onFechaMaximaChange(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000) // 7 días
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("En 1 semana")
                }

                Spacer(Modifier.height(4.dp))

                // Fila 4 de botones
                Button(
                    onClick = {
                        onFechaMaximaChange(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000) // 2 semanas
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("En 2 semanas")
                }

                Spacer(Modifier.height(4.dp))

                // Fila 5 de botones
                Button(
                    onClick = {
                        onFechaMaximaChange(System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000) // 1 mes
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("En 1 mes")
                }

                Spacer(Modifier.height(4.dp))

                // Botón para quitar fecha
                Button(
                    onClick = {
                        onFechaMaximaChange(0) // Quitar fecha
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = fechaMaxima > 0
                ) {
                    Text("Quitar fecha límite")
                }
            }

            Spacer(Modifier.height(8.dp))

            // Checkbox para urgente
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Checkbox(
                    checked = urgente,
                    onCheckedChange = onUrgenteChange
                )
                Text(
                    "Marcar como urgente",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Spacer(Modifier.height(16.dp))

            // Botón para agregar nota
            Button(
                onClick = {
                    if (esModoEdicion) {
                        onActualizarNota()
                    } else {
                        onAgregarNota()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = titulo.isNotBlank() && texto.isNotBlank()
            ) {
                //Dependiendo de si estamos en modo edición o no saldrá un texto diferente
                Text(if (esModoEdicion) "Actualizar Nota" else "Agregar Nota")
            }
        }
    }
}