package com.example.proyect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador_recycler_listar_empleado (val listaEmpleados : ArrayList<BDContactModel_empleado>): RecyclerView.Adapter<Adaptador_recycler_listar_empleado.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador_recycler_listar_empleado.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.modelo_listar_empleado,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listaEmpleados.size
    }

    override fun onBindViewHolder(holder: Adaptador_recycler_listar_empleado.ViewHolder, position: Int) {
        holder.bindItems(listaEmpleados[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(contac:BDContactModel_empleado){

            val ID_EMPLEADO=itemView.findViewById(R.id.xID_empleado) as TextView
            ID_EMPLEADO.text=contac.ID_empleado.toString()

            val NOMBRE_EMPLEADO=itemView.findViewById(R.id.xnombre_empleado) as TextView
            NOMBRE_EMPLEADO.text=contac.Nombre_empleado

            val CORREO_EMPLEADO=itemView.findViewById(R.id.xcorreo_empleado) as TextView
            CORREO_EMPLEADO.text=contac.Correo_empleado

            val EDAD_EMPLEADO=itemView.findViewById(R.id.xedad_empleado) as TextView
            EDAD_EMPLEADO.text=contac.edad_empleado.toString()

            val RFC_EMPLEADO=itemView.findViewById(R.id.xRFC_empleado) as TextView
            RFC_EMPLEADO.text=contac.RFC

        }
    }
}