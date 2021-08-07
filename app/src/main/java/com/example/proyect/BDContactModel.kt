package com.example.proyect

class BDContactModel_empleado(
    val Nombre_empleado: String, val Correo_empleado: String,
    val edad_empleado: Int, val RFC: String, val ID_empleado: Int
)

class BDContactModel_servicio(
    val ID_servicio: Int, val ID_empleado_lserv: Int
    , val ID_proyecto_lserv: Int, val Variante: String,
    val Descripcion: String
)

class BDContactModel_proyecto(
    val TiempoProyecto: String, val Variante: String
    , val descripcion: String, val ID_proyecto: Int
)

class BDContactModel_cliente(
    val Nombre_cliente: String, val Correo_cliente: String
    , val Edad_cliente: Int, val Telefono_cliente: Double, val ID_cliente: Int
)

