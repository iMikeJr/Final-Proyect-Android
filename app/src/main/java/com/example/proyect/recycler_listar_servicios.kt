package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_listar_servicios.*

class recycler_listar_servicios : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_listar_servicios)

        btn_listar_servicios.setOnClickListener(this)

        btn_listar_servicios.setOnClickListener{
            Toast.makeText(this,"Listar servicios", Toast.LENGTH_LONG).show()
            val BDHelper=BDHelper(this)
            var listadecontactos=findViewById<RecyclerView>(R.id.recyclerview_listar_servicios)

            //add layout manager
            if(listadecontactos!=null){
                listadecontactos.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
            }
            val contactos=ArrayList<BDContactModel_servicio>()
            var users= BDHelper.listarServicios()

            users.forEach{
                contactos.add(BDContactModel_servicio(it.ID_servicio,it.ID_empleado_lserv,it.ID_proyecto_lserv,it.Variante,it.Descripcion))
            }
            val adapter=adaptador_recycler_listar_servicio(contactos)
            listadecontactos.adapter=adapter
        }


    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}