package com.example.proyect

import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteStatement
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form__agregar_empleado.*

class form_Agregar_empleado : AppCompatActivity(), View.OnClickListener {

    lateinit var BD_HELPER: BDHelper

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form__agregar_empleado)
        //listener para el boton
        btnRegistrar.setOnClickListener(this)

    }//final override

    fun agregarAlaBD() {
        BD_HELPER = BDHelper(this)
        val Nombre_empleado: EditText = findViewById(R.id.FRMnombre_empleado)
        val Correo_empleado: EditText = findViewById(R.id.FRMcorreo_empleado)
        val Edad_empleado: EditText = findViewById(R.id.FRMedad_empleado)
        val RFC_empleado: EditText = findViewById(R.id.FRMRFC_empleado)
        val ID_empleado: EditText = findViewById(R.id.FRMprimary_keys)

        var Nombre_empleado_text = Nombre_empleado.text.toString()
        var Correo_empleado_text = Correo_empleado.text.toString()
        var Edad_empleado_text = Edad_empleado.text.toString().toInt()
        var rfc_empleado_text = RFC_empleado.text.toString()
        var ID_empleado_text = ID_empleado.text.toString().toInt()

        var result = BD_HELPER.agregarEmpleado(
            BDContactModel_empleado(
                Nombre_empleado = Nombre_empleado_text,
                Correo_empleado = Correo_empleado_text,
                edad_empleado = Edad_empleado_text,
                RFC = rfc_empleado_text,
                ID_empleado = ID_empleado_text
            )
        )
    }

    //funcion de validacion de campos
    fun validar_campos(): Boolean {
        if (FRMnombre_empleado.text.toString().isEmpty()) {
            FRMnombre_empleado.error = "El nombre no debe estar en blanco"
            return false
        } else if (FRMcorreo_empleado.text.toString().isEmpty()) {
            FRMcorreo_empleado.error = "El correo no debe estar en blanco"
            return false
        } else if (FRMedad_empleado.text.toString().isEmpty()) {
            FRMedad_empleado.error = "La edad no debe estar en blanco"
            return false
        } else if (FRMRFC_empleado.text.toString().isEmpty()) {
            FRMRFC_empleado.error = "El RFC no debe estar en blanco"
            return false
        } else if (FRMprimary_keys.text.toString().isEmpty()) {
            FRMprimary_keys.error = "El ID no debe estar en blanco"
            return false
        }
        return true
    }//final de fx validar campos


    //view de los elementos del programa
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegistrar -> {
                if (validar_campos()) {
                    Toast.makeText(this, "Solicitud para agregar enviada", Toast.LENGTH_LONG).show()
                    agregarAlaBD()
                } else {
                    Toast.makeText(this, "Error de registro", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}