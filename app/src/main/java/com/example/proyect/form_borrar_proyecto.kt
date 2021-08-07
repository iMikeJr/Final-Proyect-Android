package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form_borrar_proyecto.*

class form_borrar_proyecto : AppCompatActivity(), View.OnClickListener {

    lateinit var BDHelper: BDHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_borrar_proyecto)
        btnBorrar_proyecto.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnBorrar_proyecto -> {
                if (validar()) {
                    Toast.makeText(this, "Borrado con éxito", Toast.LENGTH_LONG).show()
                    AgregarAlaBD()
                } else {
                    Toast.makeText(this, "Error de eliminación", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


    fun validar(): Boolean {
        if (FRM_borrar_by_ID_proyecto.text.toString().isEmpty()) {
            FRM_borrar_by_ID_proyecto.error = "Para borrar un proyecto ingresa correctamente el ID"
            return false
        }
        return true
    }//final de fx validar

    private fun AgregarAlaBD() {
        BDHelper = BDHelper(this)
        var userid = this.FRM_borrar_by_ID_proyecto.text.toString()
        var result = BDHelper.borrar_proyecto(userid)
    }


}