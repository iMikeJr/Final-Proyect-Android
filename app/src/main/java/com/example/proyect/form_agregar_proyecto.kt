package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form_agregar_proyecto.*

class form_agregar_proyecto : AppCompatActivity(), View.OnClickListener {
    lateinit var BD_HELPER: BDHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_agregar_proyecto)
        btnRegistrar_Registrar_proyecto.setOnClickListener(this)
    }

    fun validar(): Boolean {
        if (FRM_agregar_tiempo_proyecto.text.toString().isEmpty()) {
            FRM_agregar_tiempo_proyecto.error = "El tiempo del proyecto no debe estar en blanco"
            return false
        } else if (FRM_Agregar_variante_proyecto.text.toString().isEmpty()) {
            FRM_Agregar_variante_proyecto.error = "La variante no debe estar en blanco"
            return false
        } else if (FRM_agregar_descripcion_proyecto.text.toString().isEmpty()) {
            FRM_agregar_descripcion_proyecto.error = "La descripción no debe estar en blanco"
            return false
        } else if (FRM_agregar_id_proyecto.text.toString().isEmpty()) {
            FRM_agregar_id_proyecto.error = "El ID no debe estar en blanco"
            return false
        }
        return true

    }//final de fx validar
    //funcion para agregar a la base de datos
    fun AgregarAlaBD() {

        BD_HELPER = BDHelper(this)
        val id_proyecto: EditText = findViewById(R.id.FRM_agregar_id_proyecto)
        val tiempo: EditText = findViewById(R.id.FRM_agregar_tiempo_proyecto)
        val variante: EditText = findViewById(R.id.FRM_Agregar_variante_proyecto)
        val descripcionbreve: EditText = findViewById(R.id.FRM_agregar_descripcion_proyecto)

        var id_proyecto_text = id_proyecto.text.toString().toInt()
        var tiempo_text = tiempo.text.toString()
        var variante_text = variante.text.toString()
        var descripcionbreve_text = descripcionbreve.text.toString()

        var result = BD_HELPER.agregarProtecto(
            BDContactModel_proyecto(TiempoProyecto = tiempo_text,Variante = variante_text,descripcion = descripcionbreve_text,ID_proyecto = id_proyecto_text)
        )

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegistrar_Registrar_proyecto -> {
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