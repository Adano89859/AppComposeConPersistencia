package com.example.appcomposeconpersistencia.modelo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

//Aquí están las acciones CRUD que se pueden hacer con las notas, y será usado para el repository
@Dao
interface NotaDao {

    //Permite obtener odas las notas
    @Query("SELECT * FROM Notas ORDER BY id DESC")
    fun obtenerNotas(): Flow<List<NotaEntity>>

    //Permite crear notas
    @Insert
    suspend fun insertar(nota: NotaEntity)

    //Permite actualizar notas
    @Update
    suspend fun editar(nota: NotaEntity)

    //Permite borrar notas
    @Delete
    suspend fun borrar(nota: NotaEntity)

    //Permite indicar si una nota es urgente y cambiar entre urgente y no urgente
    @Query("UPDATE Notas SET urgente = NOT urgente WHERE id = :id")
    suspend fun alternarUrgente(id: Int)

}