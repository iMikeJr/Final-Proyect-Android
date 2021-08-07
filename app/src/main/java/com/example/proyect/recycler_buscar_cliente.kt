package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_buscar_cliente.*
import kotlinx.android.synthetic.main.activity_recycler_buscar_empleado.*

class recycler_buscar_cliente : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_buscar_cliente)

        btn_buscar_cliente.setOnClickListener(this)

        btn_buscar_cliente.setOnClickListener{
            if (FRM_buscar_by_ID_cliente.text.toString().isEmpty()) {
                FRM_buscar_by_ID_cliente.error = "Para buscar un cliente ingresa correctamente el ID"

            }else
            {
                Toast.makeText(this,"Buscar cliente por id", Toast.LENGTH_LONG).show()
                val BDHelper=BDHelper(this)
                var listadecontactos=findViewById<RecyclerView>(R.id.recyclerview_buscar_cliente)

                //add layout manager
                if(listadecontactos!=null){
                    listadecontactos.layoutManager=
                        LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
                }
                val contactos=ArrayList<BDContactModel_cliente>()
                var users= BDHelper.search_cliente(FRM_buscar_by_ID_cliente.text.toString())

                users.forEach{
                    contactos.add(BDContactModel_cliente(it.Nombre_cliente,it.Correo_cliente,it.Edad_cliente,it.Telefono_cliente,it.ID_cliente))
                }
                val adapter=Adaptador_recycler_buscar_cliente(contactos)
                listadecontactos.adapter=adapter
            }
        }

    }

    override fun onClick(v: View?) {

    }
}