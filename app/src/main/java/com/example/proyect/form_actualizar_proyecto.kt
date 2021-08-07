package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form_actualizar_proyecto.*
import kotlinx.android.synthetic.main.activity_form_agregar_proyecto.*

class form_actualizar_proyecto : AppCompatActivity(), View.OnClickListener {
    lateinit var BD_HELPER: BDHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_actualizar_proyecto)
        btn_actualizar_proyecto.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_actualizar_proyecto -> {
                if (validar()) {
                    Toast.makeText(this, "Actualización enviada", Toast.LENGTH_LONG).show()
                    AgregarAlaBD()
                } else {
                    Toast.makeText(this, "Error de actualización", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun AgregarAlaBD() {
        BD_HELPER = BDHelper(this)
        val id_proyecto: EditText = findViewById(R.id.FRM_actualizar_id_proyecto)
        val tiempo: EditText = findViewById(R.id.FRM_actualizar_tiempo_proyecto)
        val variante: EditText = findViewById(R.id.FRM_actualizar_variante_proyecto)
        val descripcionbreve: EditText = findViewById(R.id.FRM_actualizar_descripcion_proyecto)

        var id_proyecto_text = id_proyecto.text.toString().toInt()
        var tiempo_text = tiempo.text.toString()
        var variante_text = variante.text.toString()
        var descripcionbreve_text = descripcionbreve.text.toString()

        var result = BD_HELPER.Actualizar_proyecto(
            BDContactModel_proyecto(TiempoProyecto = tiempo_text,Variante = variante_text,descripcion = descripcionbreve_text,ID_proyecto = id_proyecto_text)
        )
    }

    private fun validar(): Boolean {
        if (FRM_actualizar_tiempo_proyecto.text.toString().isEmpty()) {
            FRM_actualizar_tiempo_proyecto.error = "El tiempo del proyecto no debe estar en blanco"
            return false
        } else if (FRM_actualizar_variante_proyecto.text.toString().isEmpty()) {
            FRM_actualizar_variante_proyecto.error = "La variante no debe estar en blanco"
            return false
        } else if (FRM_actualizar_descripcion_proyecto.text.toString().isEmpty()) {
            FRM_actualizar_descripcion_proyecto.error = "La descripción no debe estar en blanco"
            return false
        } else if (FRM_actualizar_id_proyecto.text.toString().isEmpty()) {
            FRM_actualizar_id_proyecto.error = "El ID no debe estar en blanco"
            return false
        }
        return true
    }
}