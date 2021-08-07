package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteStatement
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form__agregar_empleado.*
import kotlinx.android.synthetic.main.activity_form_actualizar_empleado.*

class form_actualizar_empleado : AppCompatActivity(), View.OnClickListener {

    lateinit var BD_HELPER: BDHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_actualizar_empleado)
        btnActualizar_empleado.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnActualizar_empleado -> {
                if (validar_campos()) {
                    Toast.makeText(this, "Actualización enviada", Toast.LENGTH_LONG).show()
                    agregarAlaBD()
                } else {
                    Toast.makeText(this, "Error de actualización", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun agregarAlaBD() {
        BD_HELPER = BDHelper(this)
        val Nombre_empleado: EditText = findViewById(R.id.FRM_actualizar_nombre_empleado)
        val Correo_empleado: EditText = findViewById(R.id.FRM_actualizar_correo_empleado)
        val Edad_empleado: EditText = findViewById(R.id.FRM_actualizar_edad_empleado)
        val RFC_empleado: EditText = findViewById(R.id.FRM_actualizar_RFC_empleado)
        val ID_empleado: EditText = findViewById(R.id.FRM_actualizar_primary_keys)

        var Nombre_empleado_text = Nombre_empleado.text.toString()
        var Correo_empleado_text = Correo_empleado.text.toString()
        var Edad_empleado_text = Edad_empleado.text.toString().toInt()
        var rfc_empleado_text = RFC_empleado.text.toString()
        var ID_empleado_text = ID_empleado.text.toString().toInt()

        var result = BD_HELPER.Actualizar_empleado(
            BDContactModel_empleado(
                Nombre_empleado = Nombre_empleado_text,
                Correo_empleado = Correo_empleado_text,
                edad_empleado = Edad_empleado_text,
                RFC = rfc_empleado_text,
                ID_empleado = ID_empleado_text
            )
        )
    }

    private fun validar_campos(): Boolean {
        if (FRM_actualizar_nombre_empleado.text.toString().isEmpty()) {
            FRM_actualizar_nombre_empleado.error = "El nombre no debe estar en blanco"
            return false
        } else if (FRM_actualizar_correo_empleado.text.toString().isEmpty()) {
            FRM_actualizar_correo_empleado.error = "El correo no debe estar en blanco"
            return false
        } else if (FRM_actualizar_edad_empleado.text.toString().isEmpty()) {
            FRM_actualizar_edad_empleado.error = "La edad no debe estar en blanco"
            return false
        } else if (FRM_actualizar_RFC_empleado.text.toString().isEmpty()) {
            FRM_actualizar_RFC_empleado.error = "El RFC no debe estar en blanco"
            return false
        } else if (FRM_actualizar_primary_keys.text.toString().isEmpty()) {
            FRM_actualizar_primary_keys.error = "El ID no debe estar en blanco"
            return false
        }
        return true
    }
}