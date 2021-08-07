package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_listar_proyecto.*

class recycler_listar_proyecto : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_listar_proyecto)

        btn_listar_proyectos.setOnClickListener(this)

        btn_listar_proyectos.setOnClickListener{
            Toast.makeText(this,"Listar proyectos", Toast.LENGTH_LONG).show()
            val BDHelper=BDHelper(this)
            var listadecontactos=findViewById<RecyclerView>(R.id.recyclerview_listar_proyecto)

            //add layout manager
            if(listadecontactos!=null){
                listadecontactos.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
            }
            val contactos=ArrayList<BDContactModel_proyecto>()
            var users= BDHelper.listarProyecto()

            users.forEach{
                contactos.add(BDContactModel_proyecto(it.TiempoProyecto,it.Variante,it.descripcion,it.ID_proyecto))
            }
            val adapter=adaptador_recycler_listar_proyecto(contactos)
            listadecontactos.adapter=adapter
        }

    }

    override fun onClick(v: View?) {

    }
}