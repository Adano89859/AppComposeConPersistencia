package com.example.appcomposeconpersistencia.util

//Imports necesarios
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//Función para la creación de fechas a la hora de crear notas
fun formatFecha(fecha: Long): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val date = Date(fecha)
    return dateFormat.format(date)
}