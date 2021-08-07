package com.example.proyect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adaptador_recycler_buscar_proyecto(val lista_search_proyecto : ArrayList<BDContactModel_proyecto>): RecyclerView.Adapter<adaptador_recycler_buscar_proyecto.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adaptador_recycler_buscar_proyecto.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.modelo_buscar_proyecto,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return lista_search_proyecto.size
    }

    override fun onBindViewHolder(holder: adaptador_recycler_buscar_proyecto.ViewHolder, position: Int) {
        holder.bindItems(lista_search_proyecto[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(contac:BDContactModel_proyecto){

            val ID_PROYECTO = itemView.findViewById(R.id.xbuscar_ID_proyecto) as TextView
            ID_PROYECTO.text = contac.ID_proyecto.toString()

            val TIEMPO_PROYECTO = itemView.findViewById(R.id.xbuscar_tiempo_proyecto) as TextView
            TIEMPO_PROYECTO.text = contac.TiempoProyecto

            val VARIANTE_PROYECTO = itemView.findViewById(R.id.xbuscar_variante_proyecto) as TextView
            VARIANTE_PROYECTO.text = contac.Variante

            val DESC_PROYECTO = itemView.findViewById(R.id.xbuscar_desc_proyecto) as TextView
            DESC_PROYECTO.text = contac.descripcion
        }
    }


}