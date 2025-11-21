package com.example.appcomposeconpersistencia.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

//Esta es una clase que va a representar la nota de tareas que aparecerá en la aplicación
//Además tiene anotaciones para que se pueda guardar en la base de datos
@Entity(tableName = "Notas")
data class NotaEntity (
    //Estos son los atributos de dicha nota
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titulo: String,
    val texto: String,
    val fechaMaximaRealizacion: Long,
    val urgente: Boolean = false
)