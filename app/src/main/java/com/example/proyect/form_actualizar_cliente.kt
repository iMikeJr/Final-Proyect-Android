package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form_actualizar_cliente.*
import kotlinx.android.synthetic.main.activity_form_actualizar_servicio.*
import kotlinx.android.synthetic.main.activity_form_agregar_cliente.*

class form_actualizar_cliente : AppCompatActivity(), View.OnClickListener  {

    lateinit var BD_HELPER: BDHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_actualizar_cliente)
        btn_actualizar_cliente.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_actualizar_cliente -> {
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
        val Nombre_cliente: EditText = findViewById(R.id.FRM_actualizar_nombre_cliente)
        val Correo_cliente: EditText = findViewById(R.id.FRM_actualizar_correo_cliente)
        val telefono_cliente: EditText = findViewById(R.id.FRM_actualizar__Telefono_cliente)
        val edad_cliente: EditText = findViewById(R.id.FRM_actualizar_edad_cliente)
        val ID_cliente: EditText = findViewById(R.id.FRM_actualizar__ID_cliente)

        var Nombre_cliente_text = Nombre_cliente.text.toString()
        var Correo_cliente_text = Correo_cliente.text.toString()
        var telefono_cliente_text = telefono_cliente.text.toString().toDouble()
        var edad_cliente_text = edad_cliente.text.toString().toInt()
        var ID_cliente_text = ID_cliente.text.toString().toInt()

        var result = BD_HELPER.Actualizar_cliente(
            BDContactModel_cliente(
                Nombre_cliente = Nombre_cliente_text,
                Correo_cliente = Correo_cliente_text,
                Edad_cliente = edad_cliente_text,
                Telefono_cliente = telefono_cliente_text,
                ID_cliente = ID_cliente_text
            )
        )
    }

    private fun validar(): Boolean {

        if (FRM_actualizar_nombre_cliente.text.toString().isEmpty()) {
            FRM_actualizar_nombre_cliente.error = "El nombre no debe estar en blanco"
            return false
        } else if (FRM_actualizar_correo_cliente.text.toString().isEmpty()) {
            FRM_actualizar_correo_cliente.error = "El correo no debe estar en blanco"
            return false
        } else if (FRM_actualizar_edad_cliente.text.toString().isEmpty()) {
            FRM_actualizar_edad_cliente.error = "La edad no debe estar en blanco"
            return false
        } else if (FRM_actualizar__Telefono_cliente.text.toString().isEmpty()) {
            FRM_actualizar__Telefono_cliente.error = "El telefono no debe estar en blanco"
            return false
        } else if (FRM_actualizar__ID_cliente.text.toString().isEmpty()) {
            FRM_actualizar__ID_cliente.error = "El ID no debe estar en blanco"
            return false
        }
        return true
    }
}