package com.example.appcomposeconpersistencia.modelo

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@DataBase(entities = [NotaEntity::class], version = 1)
abstract class BaseDatos : RoomDatabase() {

    companion object {

        fun create(context: Context) = Room.databaseBuilder(context, BaseDatos::class.java, "Notas.db").build()

    }

}