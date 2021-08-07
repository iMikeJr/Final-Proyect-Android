package com.example.proyect

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_form_borrar_empleado.*
import kotlinx.android.synthetic.main.activity_recycler_buscar_proyecto.*
import kotlinx.android.synthetic.main.modelo_buscar_proyecto.*

class recycler_buscar_proyecto : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_buscar_proyecto)

        btn_buscar_proyecto.setOnClickListener(this)

        btn_buscar_proyecto.setOnClickListener{


            if (FRM_buscar_by_ID_proyecto.text.toString().isEmpty()) {
                FRM_buscar_by_ID_proyecto.error = "Para buscar un proyecto ingresa correctamente el ID"

            }else{
                Toast.makeText(this,"Buscar proyectos", Toast.LENGTH_LONG).show()
                val BDHelper=BDHelper(this)
                var listadecontactos=findViewById<RecyclerView>(R.id.recyclerview_buscar_proyecto)

                //add layout manager
                if(listadecontactos!=null){
                    listadecontactos.layoutManager=
                        LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
                }
                val contactos=ArrayList<BDContactModel_proyecto>()
                var users= BDHelper.search_proyecto(FRM_buscar_by_ID_proyecto.text.toString())

                users.forEach{
                    contactos.add(BDContactModel_proyecto(it.TiempoProyecto,it.Variante,it.descripcion,it.ID_proyecto))
                }
                val adapter=adaptador_recycler_buscar_proyecto(contactos)
                listadecontactos.adapter=adapter
            }

        }

    }

    override fun onClick(v: View?) {

    }
}