package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_listar__empleado.*

class recycler_listar__empleado : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_listar__empleado)

        btn_listar_empleados.setOnClickListener(this)

        btn_listar_empleados.setOnClickListener{
            Toast.makeText(this,"Listar empleados", Toast.LENGTH_LONG).show()
            val BDHelper=BDHelper(this)
            var listadecontactos=findViewById<RecyclerView>(R.id.recyclerview_listar_empleado)

            //add layout manager
            if(listadecontactos!=null){
                listadecontactos.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
            }
            val contactos=ArrayList<BDContactModel_empleado>()
            var users= BDHelper.listarEmpleado()

            users.forEach{
                contactos.add(BDContactModel_empleado(it.Nombre_empleado,it.Correo_empleado,it.edad_empleado,it.RFC,it.ID_empleado))
            }
            val adapter=Adaptador_recycler_listar_empleado(contactos)
            listadecontactos.adapter=adapter
        }

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}