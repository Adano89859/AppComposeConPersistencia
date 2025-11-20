package com.example.appcomposeconpersistencia.modelo

//Esta parte permite traspasar información de Domain a Entity, para hacer posible los traspasos de datos entre App y BBDD

//Para convertir a Domain
fun NotaEntity.toDomain() = Nota(
    id = id,
    titulo = titulo,
    texto = texto,
    fechaMaximaRealizacion = fechaMaximaRealizacion,
    urgente = urgente
)

//Para convertir a Entity
fun Nota.toEntity() = NotaEntity(
    id = id,
    titulo = titulo,
    texto = texto,
    fechaMaximaRealizacion = fechaMaximaRealizacion,
    urgente = urgente
)