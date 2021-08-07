package com.example.proyect

import android.provider.BaseColumns

class BDContract {

    //clase para la tabla de empleados
    class UserEntry_empleado : BaseColumns {
        companion object {
            val TABLE_NAME_EMPLEADO = "empleados"
            val COLUMN_ID_EMPLEADO = "id_empleado"
            val COLUMN_NAME_EMPLEADO = "nombre_empleado"
            val COLUMN_EDAD_EMPLEADO = "edad_empleado"
            val COLUMN_RFC_EMPLEADO = "rfc_empleado"
            val COLUMN_CORREO_EMPLEADO = "correo_empleado"
        }
    }

    //clase para la tabla de proyectos
    class UserEntry_proyecto : BaseColumns {
        companion object {
            val TABLE_NAME_PROYECTO = "proyectos"
            val COLUMN_TIEMPO_PROYECTO = "tiempo_proyecto"
            val COLUMN_VARIANTE_PROYECTO = "variante_proyecto"
            val COLUMN_DESCRIPCION_PROYECTO = "descripcion_proyecto"
            val COLUMN_ID_PROYECTO = "ID_proyecto"
        }
    }

    class UserEntry_servicio : BaseColumns {
        companion object {
            val TABLE_NAME_SERVICIOS = "servicios"
            val COLUMN_ID_SERVICIO = "id_servicio"
            val COLUMN_ID_EMPLEADO = "id_empleado"
            val COLUMN_ID_PROYECTO = "id_proyecto"
            val COLUMN_VARIANTE_SERVICIO = "variante_servicio"
            val COLUMN_DESCRIPCION_SERVICIO = "descripcion_servicio"
        }
    }

    class UserEntry_cliente : BaseColumns {
        companion object {
            val TABLE_NAME_CLIENTE = "clientes"
            val COLUMN_NOMBRE_CLIENTE = "nombre_cliente"
            val COLUMN_ID_CLIENTE = "id_cliente"
            val COLUMN_CORREO_CLIENTE = "correo_cliente"
            val COLUMN_EDAD_Cliente = "edad_cliente"
            val COLUMN_TELEFONO_CLIENTE = "telefono_cliente"

        }
    }
}