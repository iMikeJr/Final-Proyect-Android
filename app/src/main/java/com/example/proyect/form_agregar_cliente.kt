package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form_agregar_cliente.*

class form_agregar_cliente : AppCompatActivity(), View.OnClickListener {

    lateinit var BD_HELPER: BDHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_agregar_cliente)
        btnRegistrar_Registrar_cliente.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegistrar_Registrar_cliente -> {
                if (validar()) {
                    Toast.makeText(this, "Solicitud para agregar enviada", Toast.LENGTH_LONG).show()
                    AgregarAlaBD()
                } else {
                    Toast.makeText(this, "Error de registro", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun validar(): Boolean {
        if (FRMnombre_cliente.text.toString().isEmpty()) {
            FRMnombre_cliente.error = "El nombre no debe estar en blanco"
            return false
        } else if (FRMcorreo_cliente.text.toString().isEmpty()) {
            FRMcorreo_cliente.error = "El correo no debe estar en blanco"
            return false
        } else if (FRMedad_cliente.text.toString().isEmpty()) {
            FRMedad_cliente.error = "La edad no debe estar en blanco"
            return false
        } else if (FRM_Telefono_cliente.text.toString().isEmpty()) {
            FRM_Telefono_cliente.error = "El telefono no debe estar en blanco"
            return false
        } else if (FRM_ID_cliente.text.toString().isEmpty()) {
            FRM_ID_cliente.error = "El ID no debe estar en blanco"
            return false
        }

        return true
    }//final de fx validar

    fun AgregarAlaBD() {
        BD_HELPER = BDHelper(this)
        val Nombre_cliente: EditText = findViewById(R.id.FRMnombre_cliente)
        val Correo_cliente: EditText = findViewById(R.id.FRMcorreo_cliente)
        val telefono_cliente: EditText = findViewById(R.id.FRM_Telefono_cliente)
        val edad_cliente: EditText = findViewById(R.id.FRMedad_cliente)
        val ID_cliente: EditText = findViewById(R.id.FRM_ID_cliente)

        var Nombre_cliente_text = Nombre_cliente.text.toString()
        var Correo_cliente_text = Correo_cliente.text.toString()
        var telefono_cliente_text = telefono_cliente.text.toString().toDouble()
        var edad_cliente_text = edad_cliente.text.toString().toInt()
        var ID_cliente_text = ID_cliente.text.toString().toInt()

        var result = BD_HELPER.agregarCliente(
            BDContactModel_cliente(
                Nombre_cliente = Nombre_cliente_text,
                Correo_cliente = Correo_cliente_text,
                Edad_cliente = edad_cliente_text,
                Telefono_cliente = telefono_cliente_text,
                ID_cliente = ID_cliente_text
            )
        )
    }

}