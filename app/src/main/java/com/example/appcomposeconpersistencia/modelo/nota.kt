package com.example.appcomposeconpersistencia.modelo

//Esta es una clase que va a representar la nota de tareas que aparecerá en la aplicación
data class Nota (
    //Estos son los atributos de dicha nota
    val id: String,
    val titulo: String,
    val texto: String,
    val fechaMaximaRealizacion: Long,
    val urgente: Boolean = false
)