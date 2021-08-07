package com.example.proyect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adaptador_recycler_listar_servicio (val listaServicios : ArrayList<BDContactModel_servicio>): RecyclerView.Adapter<adaptador_recycler_listar_servicio.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adaptador_recycler_listar_servicio.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.modelo_listar_servicios,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listaServicios.size
    }

    override fun onBindViewHolder(holder: adaptador_recycler_listar_servicio.ViewHolder, position: Int) {
        holder.bindItems(listaServicios[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(contac:BDContactModel_servicio){

            val ID_PROYECTO=itemView.findViewById(R.id.xID_servicio_proyecto) as TextView
            ID_PROYECTO.text=contac.ID_proyecto_lserv.toString()

            val ID_SERVICIO=itemView.findViewById(R.id.xID_servicio) as TextView
            ID_SERVICIO.text=contac.ID_servicio.toString()

            val ID_EMPLEADO=itemView.findViewById(R.id.xID_servicio_empleado) as TextView
            ID_EMPLEADO.text=contac.ID_empleado_lserv.toString()

            val VARIANTE_SERVICIO=itemView.findViewById(R.id.xvariante_servicio) as TextView
            VARIANTE_SERVICIO.text=contac.Variante

            val DESC_SERVICIO=itemView.findViewById(R.id.xdesc_servicio) as TextView
            DESC_SERVICIO.text=contac.Descripcion

        }
    }

}