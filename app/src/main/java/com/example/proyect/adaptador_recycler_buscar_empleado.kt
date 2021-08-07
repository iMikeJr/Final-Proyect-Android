package com.example.proyect

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class adaptador_recycler_buscar_empleado (val lista_search_empleado : ArrayList<BDContactModel_empleado>): RecyclerView.Adapter<adaptador_recycler_buscar_empleado.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adaptador_recycler_buscar_empleado.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.modelo_buscar_empleado,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return lista_search_empleado.size
    }

    override fun onBindViewHolder(holder: adaptador_recycler_buscar_empleado.ViewHolder, position: Int) {
        holder.bindItems(lista_search_empleado[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(contac:BDContactModel_empleado){

            val ID_EMPLEADO=itemView.findViewById(R.id.xbuscar_ID_empleado) as TextView
            ID_EMPLEADO.text=contac.ID_empleado.toString()

            val NOMBRE_EMPLEADO=itemView.findViewById(R.id.xbuscar_nombre_empleado) as TextView
            NOMBRE_EMPLEADO.text=contac.Nombre_empleado

            val CORREO_EMPLEADO=itemView.findViewById(R.id.xbuscar_correo_empleado) as TextView
            CORREO_EMPLEADO.text=contac.Correo_empleado

            val EDAD_EMPLEADO=itemView.findViewById(R.id.xbuscar_edad_empleado) as TextView
            EDAD_EMPLEADO.text=contac.edad_empleado.toString()

            val RFC_EMPLEADO=itemView.findViewById(R.id.xbuscar_RFC_empleado) as TextView
            RFC_EMPLEADO.text=contac.RFC

        }
    }


}