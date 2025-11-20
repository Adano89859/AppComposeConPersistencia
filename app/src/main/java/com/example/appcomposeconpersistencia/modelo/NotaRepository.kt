package com.example.appcomposeconpersistencia.modelo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//Requiero las funciones CRUD de NotaDao para poder aplicarlas en el repositorio
class NotaRepository(private val dao: NotaDao) {

    //Obtener notas, para lo cual extraemos el contenido e la Entidad y lo pasamos a Domain
    fun obtenerNotas(): Flow<List<Nota>> = dao.obtenerNotas().map {
        lista -> lista.map {it.toDomain()}
    }

    //Para crear notas
    suspend fun insertar(nota : Nota){
        //Antes de insertarla, la convierto a Entity
        dao.insertar(nota.toEntity())
    }

    //Para editar notas
    suspend fun editar(nota : Nota){
        //Antes de guardarla, la convierto a Entity
        dao.editar(nota.toEntity())
    }

    //Para borrar notas
    suspend fun borrar(nota : Nota){
        //Antes de borrar, la convierto a Entity
        dao.borrar(nota.toEntity())
    }

    //Para alternar que sea urgente o no
    suspend fun alternarUrgente(id: Int){
        dao.alternarUrgente(id)
    }

}


