package com.example.proyect

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_buscar_empleado.*
import kotlinx.android.synthetic.main.activity_recycler_buscar_proyecto.*

class recycler_buscar_empleado : AppCompatActivity(), View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_buscar_empleado)
        btn_buscar_empleado.setOnClickListener(this)


        btn_buscar_empleado.setOnClickListener{
            if (FRM_buscar_by_ID_empleado.text.toString().isEmpty()) {
                FRM_buscar_by_ID_empleado.error = "Para buscar un empleado ingresa correctamente el ID"

            }else
            {
                Toast.makeText(this,"Buscar empleado por id", Toast.LENGTH_LONG).show()
                val BDHelper=BDHelper(this)
                var listadecontactos=findViewById<RecyclerView>(R.id.recyclerview_buscar_empleado)

                //add layout manager
                if(listadecontactos!=null){
                    listadecontactos.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
                }
                val contactos=ArrayList<BDContactModel_empleado>()
                var users= BDHelper.search_empleado(FRM_buscar_by_ID_empleado.text.toString())

                users.forEach{
                    contactos.add(BDContactModel_empleado(it.Nombre_empleado,it.Correo_empleado,it.edad_empleado,it.RFC,it.ID_empleado))
                }
                val adapter=adaptador_recycler_buscar_empleado(contactos)
                listadecontactos.adapter=adapter
            }
        }

    }

    override fun onClick(v: View?) {

    }


}
