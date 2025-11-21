package com.example.appcomposeconpersistencia.modelo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Declaro la base de datos y qué tabla tendrá(la de notas)
@Database(entities = [NotaEntity::class], version = 1)
abstract class BaseDatos : RoomDatabase() {
    //Indico el Dao a usar para poder trabajar con las acciones CRUD de las notas tanto para base de datos como para en la app
    abstract fun notaDao(): NotaDao
    //Compartimento para indicar utilidades en la clase, me es necesario para poder crear la base de datos
    companion object {
        //Creo la base de datos
        fun create(context: Context) = Room.databaseBuilder(context, BaseDatos::class.java, "Notas.db").build()
    }
}