package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form__agregar_empleado.*
import kotlinx.android.synthetic.main.activity_form_agregar_servicio.*

class form_agregar_servicio : AppCompatActivity(), View.OnClickListener {
    lateinit var BD_HELPER: BDHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_agregar_servicio)
        btnRegistrar_Registrar_servicio.setOnClickListener(this)
    }

    private fun validar(): Boolean {

        if (FRM_ID_servicio.text.toString().isEmpty()) {
            FRM_ID_servicio.error = "El ID servicio no debe estar en blanco"
            return false
        } else if (FRM_ID_empleado_servicio.text.toString().isEmpty()) {
            FRM_ID_empleado_servicio.error = "El ID empleado no debe estar en blanco"
            return false
        } else if (FRM_ID_proyecto_servicio.text.toString().isEmpty()) {
            FRM_ID_proyecto_servicio.error = "El ID proyecto no debe estar en blanco"
            return false
        } else if (FRM_variante_servicio.text.toString().isEmpty()) {
            FRM_variante_servicio.error = "La variante no debe estar en blanco"
            return false
        } else if (FRM_Descripcion_servicio.text.toString().isEmpty()) {
            FRM_Descripcion_servicio.error = "La descripción no debe estar en blanco"
            return false
        }

        return true
    }

    fun AgregarAlaBD() {
        BD_HELPER = BDHelper(this)
        val id_proyecto: EditText = findViewById(R.id.FRM_ID_proyecto_servicio)
        val id_empleado: EditText = findViewById(R.id.FRM_ID_empleado_servicio)
        val id_servicio: EditText = findViewById(R.id.FRM_ID_servicio)
        val descripcionbreve: EditText = findViewById(R.id.FRM_Descripcion_servicio)
        val variante: EditText = findViewById(R.id.FRM_variante_servicio)

        var id_proyecto_text = id_proyecto.text.toString().toInt()
        var id_empleado_text = id_empleado.text.toString().toInt()
        var id_servicio_text = id_servicio.text.toString().toInt()
        var variante_text = variante.text.toString()
        var descripcionbreve_text = descripcionbreve.text.toString()

        var result = BD_HELPER.agregarServicio(
            BDContactModel_servicio(
                ID_servicio = id_servicio_text,
                ID_empleado_lserv = id_empleado_text,
                ID_proyecto_lserv = id_proyecto_text,
                Variante = variante_text,
                Descripcion = descripcionbreve_text
            )
        )

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegistrar_Registrar_servicio -> {
                if (validar()) {
                    Toast.makeText(this, "Solicitud para agregar enviada", Toast.LENGTH_LONG).show()
                    AgregarAlaBD()
                } else {
                    Toast.makeText(this, "Error de registro", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}