package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_buscar_proyecto.*
import kotlinx.android.synthetic.main.activity_recycler_buscar_servicio.*

class recycler_buscar_servicio : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_buscar_servicio)

        btn_buscar_servicio.setOnClickListener(this)
        btn_buscar_servicio.setOnClickListener{
            if (FRM_buscar_by_ID_servicio.text.toString().isEmpty()) {
                FRM_buscar_by_ID_servicio.error = "Para buscar un servicio ingresa correctamente el ID"

            }else
            {
                Toast.makeText(this,"Buscar servicios", Toast.LENGTH_LONG).show()
                val BDHelper=BDHelper(this)
                var listadecontactos=findViewById<RecyclerView>(R.id.recyclerview_buscar_servicio)

                //add layout manager
                if(listadecontactos!=null){
                    listadecontactos.layoutManager=
                        LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
                }
                val contactos=ArrayList<BDContactModel_servicio>()
                var users= BDHelper.search_servicios(FRM_buscar_by_ID_servicio.text.toString())

                users.forEach{
                    contactos.add(BDContactModel_servicio(it.ID_servicio,it.ID_empleado_lserv,it.ID_proyecto_lserv,it.Variante,it.Descripcion))
                }
                val adapter=adaptador_recycler_buscar_servicio(contactos)
                listadecontactos.adapter=adapter
            }
        }


    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}