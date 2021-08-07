package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_listar__empleado.*
import kotlinx.android.synthetic.main.activity_recycler_listar_cliente.*

class recycler_listar_cliente : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_listar_cliente)

        btn_listar_clientes.setOnClickListener(this)

        btn_listar_clientes.setOnClickListener{
            Toast.makeText(this,"Listar clientes", Toast.LENGTH_LONG).show()
            val BDHelper=BDHelper(this)
            var listadecontactos=findViewById<RecyclerView>(R.id.recyclerview_listar_cliente)

            //add layout manager
            if(listadecontactos!=null){
                listadecontactos.layoutManager=
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
            }
            val contactos=ArrayList<BDContactModel_cliente>()
            var users= BDHelper.listarCliente()

            users.forEach{
                contactos.add(BDContactModel_cliente(it.Nombre_cliente,it.Correo_cliente,it.Edad_cliente,it.Telefono_cliente,it.ID_cliente))
            }
            val adapter=adaptador_recycler_listar_cliente(contactos)
            listadecontactos.adapter=adapter
        }






    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}