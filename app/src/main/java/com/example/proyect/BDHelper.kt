package com.example.proyect

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.*
import java.util.ArrayList

/**********************************************************************************************/
/**
 * * .d8888b.  .d88888b. 8888888b. 88888888888888888b.      888888b.Y88b   d88P     888b     d8888888888888    d8P 8888888888
d88P  Y88bd88P" "Y88b888  "Y88b888       888  "Y88b     888  "88bY88b d88P      8888b   d8888  888  888   d8P  888
888    888888     888888    888888       888    888     888  .88P Y88o88P       88888b.d88888  888  888  d8P   888
888       888     888888    8888888888   888    888     8888888K.  Y888P        888Y88888P888  888  888d88K    8888888
888       888     888888    888888       888    888     888  "Y88b  888         888 Y888P 888  888  8888888b   888
888    888888     888888    888888       888    888     888    888  888         888  Y8P  888  888  888  Y88b  888
Y88b  d88PY88b. .d88P888  .d88P888       888  .d88P     888   d88P  888         888   "   888  888  888   Y88b 888
"Y8888P"  "Y88888P" 8888888P" 88888888888888888P"      8888888P"   888         888       8888888888888    Y88b888888888888
 **/
/**********************************************************************************************/


class BDHelper(context: Context?) : SQLiteOpenHelper(
    context, DATABASE_NAME, null,
    DATABASE_VERSION
) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES_CLIENTES)
        db.execSQL(SQL_CREATE_ENTRIES_EMPLEADOS)
        db.execSQL(SQL_CREATE_ENTRIES_PROYECTOS)
        db.execSQL(SQL_CREATE_ENTRIES_SERVICIOS)

    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES_CLIENTES)
        db.execSQL(SQL_DELETE_ENTRIES_EMPLEADOS)
        db.execSQL(SQL_DELETE_ENTRIES_PROYECTOS)
        db.execSQL(SQL_DELETE_ENTRIES_SERVICIOS)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    /**********************************************************************************************/
    /** METHOD INSERT GENERAL **/

    /**meotodo insertar oara empleado**/
    @Throws(SQLiteConstraintException::class)
    fun agregarEmpleado(user: BDContactModel_empleado): Boolean {

        val db = writableDatabase
        val values = ContentValues()
        values.put(BDContract.UserEntry_empleado.COLUMN_ID_EMPLEADO, user.ID_empleado)
        values.put(BDContract.UserEntry_empleado.COLUMN_NAME_EMPLEADO, user.Nombre_empleado)
        values.put(BDContract.UserEntry_empleado.COLUMN_CORREO_EMPLEADO, user.Correo_empleado)
        values.put(BDContract.UserEntry_empleado.COLUMN_RFC_EMPLEADO, user.RFC)
        values.put(BDContract.UserEntry_empleado.COLUMN_EDAD_EMPLEADO, user.edad_empleado)

        //insert a new row, getting back the value of the primary key to the new row
        val newRowId = db.insert(BDContract.UserEntry_empleado.TABLE_NAME_EMPLEADO, null, values)
        return true
    }

    /**metodo insertar para cliente**/
    @Throws(SQLiteConstraintException::class)
    fun agregarCliente(user: BDContactModel_cliente): Boolean {

        val db = writableDatabase
        val values = ContentValues()
        values.put(BDContract.UserEntry_cliente.COLUMN_ID_CLIENTE, user.ID_cliente)
        values.put(BDContract.UserEntry_cliente.COLUMN_NOMBRE_CLIENTE, user.Nombre_cliente)
        values.put(BDContract.UserEntry_cliente.COLUMN_TELEFONO_CLIENTE, user.Telefono_cliente)
        values.put(BDContract.UserEntry_cliente.COLUMN_CORREO_CLIENTE, user.Correo_cliente)
        values.put(BDContract.UserEntry_cliente.COLUMN_EDAD_Cliente, user.Edad_cliente)

        //insert a new row, getting back the value of the primary key to the new row
        val newRowId = db.insert(BDContract.UserEntry_cliente.TABLE_NAME_CLIENTE, null, values)
        return true
    }

    /**metodo insertar para proyecto**/
    @Throws(SQLiteConstraintException::class)
    fun agregarProtecto(user: BDContactModel_proyecto): Boolean {

        val db = writableDatabase
        val values = ContentValues()
        values.put(BDContract.UserEntry_proyecto.COLUMN_ID_PROYECTO, user.ID_proyecto)
        values.put(BDContract.UserEntry_proyecto.COLUMN_TIEMPO_PROYECTO, user.TiempoProyecto)
        values.put(BDContract.UserEntry_proyecto.COLUMN_VARIANTE_PROYECTO, user.Variante)
        values.put(BDContract.UserEntry_proyecto.COLUMN_DESCRIPCION_PROYECTO, user.descripcion)

        //insert a new row, getting back the value of the primary key to the new row
        val newRowId = db.insert(BDContract.UserEntry_proyecto.TABLE_NAME_PROYECTO, null, values)
        return true
    }

    /**metodo insertar para servicio**/
    @Throws(SQLiteConstraintException::class)
    fun agregarServicio(user: BDContactModel_servicio): Boolean {

        val db = writableDatabase
        val values = ContentValues()
        values.put(BDContract.UserEntry_servicio.COLUMN_ID_SERVICIO, user.ID_servicio)
        values.put(BDContract.UserEntry_servicio.COLUMN_ID_PROYECTO, user.ID_proyecto_lserv)
        values.put(BDContract.UserEntry_servicio.COLUMN_ID_EMPLEADO, user.ID_empleado_lserv)
        values.put(BDContract.UserEntry_servicio.COLUMN_VARIANTE_SERVICIO, user.Variante)
        values.put(BDContract.UserEntry_servicio.COLUMN_DESCRIPCION_SERVICIO, user.Descripcion)

        //insert a new row, getting back the value of the primary key to the new row
        val newRowId = db.insert(BDContract.UserEntry_servicio.TABLE_NAME_SERVICIOS, null, values)
        return true
    }

    /** FINAL METHOD INSERT GENERAL **/
    /**********************************************************************************************/


    /**
     * .d8888b.  .d88888b. 8888888b. 88888888888888888b.      888888b.Y88b   d88P     888b     d8888888888888    d8P 8888888888
    d88P  Y88bd88P" "Y88b888  "Y88b888       888  "Y88b     888  "88bY88b d88P      8888b   d8888  888  888   d8P  888
    888    888888     888888    888888       888    888     888  .88P Y88o88P       88888b.d88888  888  888  d8P   888
    888       888     888888    8888888888   888    888     8888888K.  Y888P        888Y88888P888  888  888d88K    8888888
    888       888     888888    888888       888    888     888  "Y88b  888         888 Y888P 888  888  8888888b   888
    888    888888     888888    888888       888    888     888    888  888         888  Y8P  888  888  888  Y88b  888
    Y88b  d88PY88b. .d88P888  .d88P888       888  .d88P     888   d88P  888         888   "   888  888  888   Y88b 888
    "Y8888P"  "Y88888P" 8888888P" 88888888888888888P"      8888888P"   888         888       8888888888888    Y88b8888888888
     * **/


    /**********************************************************************************************/
    /** METHOD BORRAR GENERAL **/

    /** METHOD DELETE EMPLEADO **/
    @Throws(SQLiteConstraintException::class)
    fun borrar_empleado(userid: String): Boolean {
        //gets data from repository on writting mode
        val db = writableDatabase
        //defines the "Where" clause from the query
        val selection = BDContract.UserEntry_empleado.COLUMN_ID_EMPLEADO + " LIKE ?"
        //specifies the arguments in order of position marker
        val selectionArgs = arrayOf(userid)
        //run SQL Query
        db.delete(BDContract.UserEntry_empleado.TABLE_NAME_EMPLEADO, selection, selectionArgs)
        return true
    }
    /** FINALIZAR DELETE EMPLEADO **/

    /** METHOD DELETE CLIENTE **/
    @Throws(SQLiteConstraintException::class)
    fun borrar_cliente(userid: String): Boolean {
        //gets data from repository on writting mode
        val db = writableDatabase
        //defines the "Where" clause from the query
        val selection = BDContract.UserEntry_cliente.COLUMN_ID_CLIENTE + " LIKE ?"
        //specifies the arguments in order of position marker
        val selectionArgs = arrayOf(userid)
        //run SQL Query
        db.delete(BDContract.UserEntry_cliente.TABLE_NAME_CLIENTE, selection, selectionArgs)
        return true
    }
    /** FINALIZAR DELETE CLIENTE **/

    /** METHOD DELETE PROYECTO **/
    @Throws(SQLiteConstraintException::class)
    fun borrar_proyecto(userid: String): Boolean {
        //gets data from repository on writting mode
        val db = writableDatabase
        //defines the "Where" clause from the query
        val selection = BDContract.UserEntry_proyecto.COLUMN_ID_PROYECTO + " LIKE ?"
        //specifies the arguments in order of position marker
        val selectionArgs = arrayOf(userid)
        //run SQL Query
        db.delete(BDContract.UserEntry_proyecto.TABLE_NAME_PROYECTO, selection, selectionArgs)
        return true
    }
    /** FINALIZAR DELETE PROYECTO **/

    /** METHOD DELETE SERVICIO **/
    @Throws(SQLiteConstraintException::class)
    fun borrar_servicio(userid: String): Boolean {
        //gets data from repository on writting mode
        val db = writableDatabase
        //defines the "Where" clause from the query
        val selection = BDContract.UserEntry_servicio.COLUMN_ID_SERVICIO + " LIKE ?"
        //specifies the arguments in order of position marker
        val selectionArgs = arrayOf(userid)
        //run SQL Query
        db.delete(BDContract.UserEntry_servicio.TABLE_NAME_SERVICIOS, selection, selectionArgs)
        return true
    }
    /** FINALIZAR DELETE SERVICIO **/
    /** FINAL METHOD BORRAR GENERAL **/


    /**********************************************************************************************/
    /**
    /**/

     * .d8888b.  .d88888b. 8888888b. 88888888888888888b.      888888b.Y88b   d88P     888b     d8888888888888    d8P 8888888888
    d88P  Y88bd88P" "Y88b888  "Y88b888       888  "Y88b     888  "88bY88b d88P      8888b   d8888  888  888   d8P  888
    888    888888     888888    888888       888    888     888  .88P Y88o88P       88888b.d88888  888  888  d8P   888
    888       888     888888    8888888888   888    888     8888888K.  Y888P        888Y88888P888  888  888d88K    8888888
    888       888     888888    888888       888    888     888  "Y88b  888         888 Y888P 888  888  8888888b   888
    888    888888     888888    888888       888    888     888    888  888         888  Y8P  888  888  888  Y88b  888
    Y88b  d88PY88b. .d88P888  .d88P888       888  .d88P     888   d88P  888         888   "   888  888  888   Y88b 888
    "Y8888P"  "Y88888P" 8888888P" 88888888888888888P"      8888888P"   888         888       8888888888888    Y88b8888888888


     * **/
    /**********************************************************************************************/


    /**********************************************************************************************/
    /** METHOD UPDATE GENERAL **/
    /** METHOD UPDATE_EMPLEADO **/
    @Throws(SQLiteConstraintException::class)
    fun Actualizar_empleado(user: BDContactModel_empleado): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(BDContract.UserEntry_empleado.COLUMN_ID_EMPLEADO, user.ID_empleado)
        values.put(BDContract.UserEntry_empleado.COLUMN_NAME_EMPLEADO, user.Nombre_empleado)
        values.put(BDContract.UserEntry_empleado.COLUMN_EDAD_EMPLEADO, user.edad_empleado)
        values.put(BDContract.UserEntry_empleado.COLUMN_CORREO_EMPLEADO, user.Correo_empleado)
        values.put(BDContract.UserEntry_empleado.COLUMN_RFC_EMPLEADO, user.RFC)
        //insert a new row, getting back the value of the primary key to the new row
        //this method provide us a quick update of data.
        /** Important code **/
        val newRowId = db.update(
            BDContract.UserEntry_empleado.TABLE_NAME_EMPLEADO,
            values,
            "${BDContract.UserEntry_empleado.COLUMN_ID_EMPLEADO} = " + user.ID_empleado,
            null
        )
        return true
    }
    /** FINAL METHOD UPDATE_EMPLEADO **/

    /** METHOD UPDATE_CLIENTE **/
    @Throws(SQLiteConstraintException::class)
    fun Actualizar_cliente(user: BDContactModel_cliente): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(BDContract.UserEntry_cliente.COLUMN_ID_CLIENTE, user.ID_cliente)
        values.put(BDContract.UserEntry_cliente.COLUMN_NOMBRE_CLIENTE, user.Nombre_cliente)
        values.put(BDContract.UserEntry_cliente.COLUMN_TELEFONO_CLIENTE, user.Telefono_cliente)
        values.put(BDContract.UserEntry_cliente.COLUMN_CORREO_CLIENTE, user.Correo_cliente)
        values.put(BDContract.UserEntry_cliente.COLUMN_EDAD_Cliente, user.Edad_cliente)
        //insert a new row, getting back the value of the primary key to the new row
        //this method provide us a quick update of data.
        /** Important code **/
        val newRowId = db.update(
            BDContract.UserEntry_cliente.TABLE_NAME_CLIENTE,
            values,
            "${BDContract.UserEntry_cliente.COLUMN_ID_CLIENTE} = " + user.ID_cliente,
            null
        )
        return true
    }
    /** FINAL METHOD UPDATE_CLIENTE **/


    /** METHOD UPDATE_PROYECTO **/
    @Throws(SQLiteConstraintException::class)
    fun Actualizar_proyecto(user: BDContactModel_proyecto): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(BDContract.UserEntry_proyecto.COLUMN_ID_PROYECTO, user.ID_proyecto)
        values.put(BDContract.UserEntry_proyecto.COLUMN_TIEMPO_PROYECTO, user.TiempoProyecto)
        values.put(BDContract.UserEntry_proyecto.COLUMN_VARIANTE_PROYECTO, user.Variante)
        values.put(BDContract.UserEntry_proyecto.COLUMN_DESCRIPCION_PROYECTO, user.descripcion)
        //insert a new row, getting back the value of the primary key to the new row
        //this method provide us a quick update of data.
        /** Important code **/
        val newRowId = db.update(
            BDContract.UserEntry_proyecto.TABLE_NAME_PROYECTO,
            values,
            "${BDContract.UserEntry_proyecto.COLUMN_ID_PROYECTO} = " + user.ID_proyecto,
            null
        )
        return true
    }
    /** FINAL METHOD UPDATE_PROYECTO **/

    /** METHOD UPDATE_SERVICIO **/
    @Throws(SQLiteConstraintException::class)
    fun Actualizar_servicio(user: BDContactModel_servicio): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(BDContract.UserEntry_servicio.COLUMN_ID_SERVICIO, user.ID_servicio)
        values.put(BDContract.UserEntry_servicio.COLUMN_ID_EMPLEADO, user.ID_empleado_lserv)
        values.put(BDContract.UserEntry_servicio.COLUMN_ID_PROYECTO, user.ID_proyecto_lserv)
        values.put(BDContract.UserEntry_servicio.COLUMN_VARIANTE_SERVICIO, user.Variante)
        values.put(BDContract.UserEntry_servicio.COLUMN_DESCRIPCION_SERVICIO, user.Descripcion)
        //insert a new row, getting back the value of the primary key to the new row
        //this method provide us a quick update of data.
        /** Important code **/
        val newRowId = db.update(
            BDContract.UserEntry_servicio.TABLE_NAME_SERVICIOS,
            values,
            "${BDContract.UserEntry_servicio.COLUMN_ID_SERVICIO} = " + user.ID_servicio,
            null
        )
        return true
    }
    /** FINAL METHOD UPDATE_SERVICIO **/


    /** FINAL METHOD UPDATE GENERAL **/
    /**********************************************************************************************/
    /**  * .d8888b.  .d88888b. 8888888b. 88888888888888888b.      888888b.Y88b   d88P     888b     d8888888888888    d8P 8888888888
    d88P  Y88bd88P" "Y88b888  "Y88b888       888  "Y88b     888  "88bY88b d88P      8888b   d8888  888  888   d8P  888
    888    888888     888888    888888       888    888     888  .88P Y88o88P       88888b.d88888  888  888  d8P   888
    888       888     888888    8888888888   888    888     8888888K.  Y888P        888Y88888P888  888  888d88K    8888888
    888       888     888888    888888       888    888     888  "Y88b  888         888 Y888P 888  888  8888888b   888
    888    888888     888888    888888       888    888     888    888  888         888  Y8P  888  888  888  Y88b  888
    Y88b  d88PY88b. .d88P888  .d88P888       888  .d88P     888   d88P  888         888   "   888  888  888   Y88b 888
    "Y8888P"  "Y88888P" 8888888P" 88888888888888888P"      8888888P"   888         888       8888888888888    Y88b8888888888**/
    /**********************************************************************************************/


    /**********************************************************************************************/
    /** METHOD LIST GENERAL **/

    /** METHOD LIST EMPLEADO**/
    fun listarEmpleado(): ArrayList<BDContactModel_empleado> {
        val users= ArrayList<BDContactModel_empleado>()
        val db=writableDatabase
        var cursor:Cursor?=null
        try {
            cursor=db.rawQuery("select * from "+BDContract.UserEntry_empleado.TABLE_NAME_EMPLEADO,null)
        }catch (e:SQLiteException){
            db.execSQL(SQL_CREATE_ENTRIES_EMPLEADOS)
            return ArrayList()
        }

        var nombre: String
        var RFC: String
        var e_mail: String
        var edad: Int
        var id_empleado: Int

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {

                nombre= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_empleado.COLUMN_NAME_EMPLEADO))
                RFC = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_empleado.COLUMN_RFC_EMPLEADO))
                e_mail = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_empleado.COLUMN_CORREO_EMPLEADO))
                id_empleado = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_empleado.COLUMN_ID_EMPLEADO)).toInt()
                edad = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_empleado.COLUMN_EDAD_EMPLEADO)).toInt()
                users.add(BDContactModel_empleado(nombre,e_mail,edad,RFC,id_empleado))
                cursor.moveToNext()

            }
        }
        return users
    }/** METHOD FINAL LIST EMPLEADO**/

    /** METHOD LIST CLIENTE**/
    fun listarCliente(): ArrayList<BDContactModel_cliente> {
        val users= ArrayList<BDContactModel_cliente>()
        val db=writableDatabase
        var cursor:Cursor?=null

        try {
            cursor=db.rawQuery("select * from "+BDContract.UserEntry_cliente.TABLE_NAME_CLIENTE,null)
        }catch (e:SQLiteException){
            db.execSQL(SQL_CREATE_ENTRIES_CLIENTES)
            return ArrayList()
        }

        var nombre: String
        var telefono: Double
        var e_mail: String
        var edad: Int
        var id_cliente: Int

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                nombre= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_cliente.COLUMN_NOMBRE_CLIENTE))
                telefono = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_cliente.COLUMN_TELEFONO_CLIENTE)).toDouble()
                e_mail = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_cliente.COLUMN_CORREO_CLIENTE))
                id_cliente = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_cliente.COLUMN_ID_CLIENTE)).toInt()
                edad = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_cliente.COLUMN_EDAD_Cliente)).toInt()
                users.add(BDContactModel_cliente(nombre,e_mail,edad,telefono,id_cliente))
                cursor.moveToNext()
            }
        }
        return users
    }/** METHOD FINAL LIST CLIENTE**/


    /** METHOD LIST PROYECTO**/
    fun listarProyecto(): ArrayList<BDContactModel_proyecto> {
        val users= ArrayList<BDContactModel_proyecto>()
        val db=writableDatabase
        var cursor:Cursor?=null

        try {
            cursor=db.rawQuery("select * from "+BDContract.UserEntry_proyecto.TABLE_NAME_PROYECTO,null)
        }catch (e:SQLiteException){
            db.execSQL(SQL_CREATE_ENTRIES_PROYECTOS)
            return ArrayList()
        }

        var descripcion: String
        var Tiempo: String
        var Variante: String
        var id_proyecto: Int

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                descripcion= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_proyecto.COLUMN_DESCRIPCION_PROYECTO))
                Tiempo = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_proyecto.COLUMN_TIEMPO_PROYECTO))
                Variante = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_proyecto.COLUMN_VARIANTE_PROYECTO))
                id_proyecto = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_proyecto.COLUMN_ID_PROYECTO)).toInt()
                users.add(BDContactModel_proyecto(Tiempo,Variante,descripcion,id_proyecto))
                cursor.moveToNext()
            }
        }
        return users
    }/** METHOD FINAL LIST PROYECTO**/

    /** METHOD LIST SERVICIOS**/
    fun listarServicios(): ArrayList<BDContactModel_servicio> {
        val users= ArrayList<BDContactModel_servicio>()
        val db=writableDatabase
        var cursor:Cursor?=null

        try {
            cursor=db.rawQuery("select * from "+BDContract.UserEntry_servicio.TABLE_NAME_SERVICIOS,null)
        }catch (e:SQLiteException){
            db.execSQL(SQL_CREATE_ENTRIES_SERVICIOS)
            return ArrayList()
        }


        var variante: String
        var descripcion: String
        var id_empleado: Int
        var id_servicios: Int
        var id_proyecto: Int

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {

                variante= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_servicio.COLUMN_VARIANTE_SERVICIO))
                descripcion= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_servicio.COLUMN_DESCRIPCION_SERVICIO))
                id_empleado= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_servicio.COLUMN_ID_EMPLEADO)).toInt()
                id_servicios= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_servicio.COLUMN_ID_SERVICIO)).toInt()
                id_proyecto= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_servicio.COLUMN_ID_PROYECTO)).toInt()

                users.add(BDContactModel_servicio(id_servicios,id_empleado,id_proyecto,variante,descripcion))
                cursor.moveToNext()
            }
        }
        return users
    }/** METHOD FINAL LIST SERVICIOS**/
    /** FINAL METHOD LIST GENERAL **/
    /**********************************************************************************************/

    /**********************************************************************************************/

    /**  * .d8888b.  .d88888b. 8888888b. 88888888888888888b.      888888b.Y88b   d88P     888b     d8888888888888    d8P 8888888888
    d88P  Y88bd88P" "Y88b888  "Y88b888       888  "Y88b     888  "88bY88b d88P      8888b   d8888  888  888   d8P  888
    888    888888     888888    888888       888    888     888  .88P Y88o88P       88888b.d88888  888  888  d8P   888
    888       888     888888    8888888888   888    888     8888888K.  Y888P        888Y88888P888  888  888d88K    8888888
    888       888     888888    888888       888    888     888  "Y88b  888         888 Y888P 888  888  8888888b   888
    888    888888     888888    888888       888    888     888    888  888         888  Y8P  888  888  888  Y88b  888
    Y88b  d88PY88b. .d88P888  .d88P888       888  .d88P     888   d88P  888         888   "   888  888  888   Y88b 888
    "Y8888P"  "Y88888P" 8888888P" 88888888888888888P"      8888888P"   888         888       8888888888888    Y88b8888888888**/
    /***********************************************************************************************/


    /**********************************************************************************************/
    /** METHOD BUSCAR GENERAL **/


    /** METHOD SEARCH EMPLEADO**/
    fun search_empleado(userid: String): ArrayList<BDContactModel_empleado>{
        val users=ArrayList<BDContactModel_empleado>()
        val db=writableDatabase
        var cursor: Cursor?=null
        try {
            cursor=db.rawQuery("select * from "+BDContract.UserEntry_empleado.TABLE_NAME_EMPLEADO+" WHERE "+
                    BDContract.UserEntry_empleado.COLUMN_ID_EMPLEADO+" ='"+ userid + "'",null)

        }catch (e:SQLiteException){
            //if the table is not created, create it.
            db.execSQL(SQL_CREATE_ENTRIES_EMPLEADOS)
            return ArrayList()
        }

        var nombre: String
        var RFC: String
        var e_mail: String
        var edad: Int
        var id_empleado: Int

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {

                nombre= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_empleado.COLUMN_NAME_EMPLEADO))
                RFC = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_empleado.COLUMN_RFC_EMPLEADO))
                e_mail = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_empleado.COLUMN_CORREO_EMPLEADO))
                id_empleado = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_empleado.COLUMN_ID_EMPLEADO)).toInt()
                edad = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_empleado.COLUMN_EDAD_EMPLEADO)).toInt()
                users.add(BDContactModel_empleado(nombre,e_mail,edad,RFC,id_empleado))

                cursor.moveToNext()
            }
        }
        return users
    }
    /** METHOD FINAL SEARCH EMPLEADO**/

    /** METHOD SEARCH CLIENTE **/
    fun search_cliente(userid: String): ArrayList<BDContactModel_cliente>{
        val users=ArrayList<BDContactModel_cliente>()
        val db=writableDatabase
        var cursor: Cursor?=null
        try {
            cursor=db.rawQuery("select * from "+BDContract.UserEntry_cliente.TABLE_NAME_CLIENTE+" WHERE "+
                    BDContract.UserEntry_cliente.COLUMN_ID_CLIENTE+" ='"+ userid + "'",null)

        }catch (e:SQLiteException){
            //if the table is not created, create it.
            db.execSQL(SQL_CREATE_ENTRIES_CLIENTES)
            return ArrayList()
        }

        var nombre: String
        var telefono: Double
        var e_mail: String
        var edad: Int
        var id_cliente: Int

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {

                nombre= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_cliente.COLUMN_NOMBRE_CLIENTE))
                telefono = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_cliente.COLUMN_TELEFONO_CLIENTE)).toDouble()
                e_mail = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_cliente.COLUMN_CORREO_CLIENTE))
                id_cliente = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_cliente.COLUMN_ID_CLIENTE)).toInt()
                edad = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_cliente.COLUMN_EDAD_Cliente)).toInt()
                users.add(BDContactModel_cliente(nombre,e_mail,edad,telefono,id_cliente))

                cursor.moveToNext()
            }
        }
        return users
    }
    /** METHOD FINAL SEARCH CLIENTE**/

    /** METHOD SEARCH PROYECTO **/
    fun search_proyecto(userid: String): ArrayList<BDContactModel_proyecto>{
        val users=ArrayList<BDContactModel_proyecto>()
        val db=writableDatabase
        var cursor: Cursor?=null
        try {
            cursor=db.rawQuery("select * from "+BDContract.UserEntry_proyecto.TABLE_NAME_PROYECTO+" WHERE "+
                    BDContract.UserEntry_proyecto.COLUMN_ID_PROYECTO+" ='"+ userid + "'",null)

        }catch (e:SQLiteException){
            //if the table is not created, create it.
            db.execSQL(SQL_CREATE_ENTRIES_PROYECTOS)
            return ArrayList()
        }

        var descripcion: String
        var Tiempo: String
        var Variante: String
        var id_proyecto: Int

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {

                descripcion= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_proyecto.COLUMN_DESCRIPCION_PROYECTO))
                Tiempo = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_proyecto.COLUMN_TIEMPO_PROYECTO))
                Variante = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_proyecto.COLUMN_VARIANTE_PROYECTO))
                id_proyecto = cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_proyecto.COLUMN_ID_PROYECTO)).toInt()
                users.add(BDContactModel_proyecto(Tiempo,Variante,descripcion,id_proyecto))

                cursor.moveToNext()

            }
        }
        return users
    }
    /** METHOD FINAL SEARCH PROYECTO**/

    /** METHOD SEARCH SERVICIOS**/
    fun search_servicios(userid: String): ArrayList<BDContactModel_servicio>{
        val users=ArrayList<BDContactModel_servicio>()
        val db=writableDatabase
        var cursor: Cursor?=null
        try {
            cursor=db.rawQuery("select * from "+BDContract.UserEntry_servicio.TABLE_NAME_SERVICIOS+" WHERE "+
                    BDContract.UserEntry_servicio.COLUMN_ID_SERVICIO+" ='"+ userid + "'",null)

        }catch (e:SQLiteException){
            //if the table is not created, create it.
            db.execSQL(SQL_CREATE_ENTRIES_SERVICIOS)
            return ArrayList()
        }

        var variante: String
        var descripcion: String
        var id_empleado: Int
        var id_servicios: Int
        var id_proyecto: Int

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {

                variante= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_servicio.COLUMN_VARIANTE_SERVICIO))
                descripcion= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_servicio.COLUMN_DESCRIPCION_SERVICIO))
                id_empleado= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_servicio.COLUMN_ID_EMPLEADO)).toInt()
                id_servicios= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_servicio.COLUMN_ID_SERVICIO)).toInt()
                id_proyecto= cursor.getString(cursor.getColumnIndex(BDContract.UserEntry_servicio.COLUMN_ID_PROYECTO)).toInt()

                users.add(BDContactModel_servicio(id_servicios,id_empleado,id_proyecto,variante,descripcion))
                cursor.moveToNext()
            }
        }
        return users
    }
    /** METHOD FINAL SEARCH SERVICIOS**/
    /** FINAL METHOD SEARCH GENERAL **/
    /**********************************************************************************************/


    /** CREACION DE LAS TABLAS DE LA BASE DE DATOS **/
    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "FeedReader"


        /**creacion de la tabla EMPLEADOS**/
        private val SQL_CREATE_ENTRIES_EMPLEADOS =
            "CREATE TABLE " + BDContract.UserEntry_empleado.TABLE_NAME_EMPLEADO + " (" + BDContract.UserEntry_empleado.COLUMN_ID_EMPLEADO + " INT PRIMARY KEY," +
                    BDContract.UserEntry_empleado.COLUMN_NAME_EMPLEADO + " VARCHAR," +
                    BDContract.UserEntry_empleado.COLUMN_CORREO_EMPLEADO + " VARCHAR," +
                    BDContract.UserEntry_empleado.COLUMN_EDAD_EMPLEADO + " INTEGER," +
                    BDContract.UserEntry_empleado.COLUMN_RFC_EMPLEADO + " VARCHAR)"

        private val SQL_DELETE_ENTRIES_EMPLEADOS =
            "DROP TABLE IF EXISTS " + BDContract.UserEntry_empleado.TABLE_NAME_EMPLEADO
        /**finalizacion de la tabla empleado**/


        /**creacion de la tabla PROYECTOS**/
        private val SQL_CREATE_ENTRIES_PROYECTOS =
            "CREATE TABLE " + BDContract.UserEntry_proyecto.TABLE_NAME_PROYECTO + " (" + BDContract.UserEntry_proyecto.COLUMN_ID_PROYECTO + " INT PRIMARY KEY," +
                    BDContract.UserEntry_proyecto.COLUMN_TIEMPO_PROYECTO + " VARCHAR," +
                    BDContract.UserEntry_proyecto.COLUMN_VARIANTE_PROYECTO + " VARCHAR," +
                    BDContract.UserEntry_proyecto.COLUMN_DESCRIPCION_PROYECTO + " VARCHAR)"
        private val SQL_DELETE_ENTRIES_PROYECTOS =
            "DROP TABLE IF EXISTS " + BDContract.UserEntry_proyecto.TABLE_NAME_PROYECTO
        /**Finalizacion de la tabla proyectos**/


        /**creacion de la tabla CLIENTES**/
        private val SQL_CREATE_ENTRIES_CLIENTES =
            "CREATE TABLE " + BDContract.UserEntry_cliente.TABLE_NAME_CLIENTE + " (" + BDContract.UserEntry_cliente.COLUMN_ID_CLIENTE + " INT PRIMARY KEY," +
                    BDContract.UserEntry_cliente.COLUMN_NOMBRE_CLIENTE + " VARCHAR," +
                    BDContract.UserEntry_cliente.COLUMN_CORREO_CLIENTE + " VARCHAR," +
                    BDContract.UserEntry_cliente.COLUMN_TELEFONO_CLIENTE + " INTEGER," +
                    BDContract.UserEntry_cliente.COLUMN_EDAD_Cliente + " INTEGER)"

        private val SQL_DELETE_ENTRIES_CLIENTES =
            "DROP TABLE IF EXISTS " + BDContract.UserEntry_cliente.TABLE_NAME_CLIENTE
        /**FINALIZACION de la tabla CLIENTES**/


        /********DECLARACION ------ VARIABLES FNK*/
        //declaracion de variables de tabla empleado (uso de llaves foraneas)
        val idempleado: String = BDContract.UserEntry_empleado.COLUMN_ID_EMPLEADO
        val tablaempleado: String = BDContract.UserEntry_empleado.TABLE_NAME_EMPLEADO
        val foranea_id_empleado: String = BDContract.UserEntry_servicio.COLUMN_ID_EMPLEADO

        //declaracion de variables de tabla proyecto (uso de llaves foraneas)
        val idproyecto: String = BDContract.UserEntry_proyecto.COLUMN_ID_PROYECTO
        val tablaproyecto: String = BDContract.UserEntry_proyecto.TABLE_NAME_PROYECTO
        val foranea_id_proyecto: String = BDContract.UserEntry_proyecto.COLUMN_ID_PROYECTO

        /*******DECLARACION ------ VARIABLES FNK*/

        /**creacion de la tabla servicios**/
        private val SQL_CREATE_ENTRIES_SERVICIOS =
            "CREATE TABLE " + BDContract.UserEntry_servicio.TABLE_NAME_SERVICIOS + " (" + BDContract.UserEntry_servicio.COLUMN_ID_SERVICIO + " INT PRIMARY KEY," +
                    BDContract.UserEntry_servicio.COLUMN_ID_EMPLEADO + " INTEGER," +
                    BDContract.UserEntry_servicio.COLUMN_ID_PROYECTO + " INTEGER," +
                    BDContract.UserEntry_servicio.COLUMN_VARIANTE_SERVICIO + " VARCHAR," +
                    BDContract.UserEntry_servicio.COLUMN_DESCRIPCION_SERVICIO + " VARCHAR," +
                    " FOREIGN KEY($idempleado) REFERENCES ${tablaempleado + (" (${foranea_id_empleado})")}," +
                    " FOREIGN KEY($idproyecto) REFERENCES ${tablaproyecto + (" (${foranea_id_proyecto})")}" +
                    " ON UPDATE CASCADE " +
                    "ON DELETE CASCADE)"

        private val SQL_DELETE_ENTRIES_SERVICIOS =
            "DROP TABLE IF EXISTS " + BDContract.UserEntry_servicio.TABLE_NAME_SERVICIOS

    }

}