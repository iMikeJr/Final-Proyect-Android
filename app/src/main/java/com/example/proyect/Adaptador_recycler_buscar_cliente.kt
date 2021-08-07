package com.example.proyect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador_recycler_buscar_cliente (val lista_search_cliente : ArrayList<BDContactModel_cliente>): RecyclerView.Adapter<Adaptador_recycler_buscar_cliente.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador_recycler_buscar_cliente.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.modelo_buscar_cliente,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return lista_search_cliente.size
    }

    override fun onBindViewHolder(holder: Adaptador_recycler_buscar_cliente.ViewHolder, position: Int) {
        holder.bindItems(lista_search_cliente[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(contac:BDContactModel_cliente){

            val ID_CLIENTE=itemView.findViewById(R.id.xbuscar_ID_cliente) as TextView
            ID_CLIENTE.text=contac.ID_cliente.toString()

            val NOMBRE_CLIENTE=itemView.findViewById(R.id.xbuscar_nombre_cliente) as TextView
            NOMBRE_CLIENTE.text=contac.Nombre_cliente

            val CORREO_CLIENTE=itemView.findViewById(R.id.xbuscar_correo_cliente) as TextView
            CORREO_CLIENTE.text=contac.Correo_cliente

            val TELEFONO_CLIENTE=itemView.findViewById(R.id.xbuscar_telefono_cliente) as TextView
            TELEFONO_CLIENTE.text=contac.Telefono_cliente.toString()

            val EDAD_CLIENTE=itemView.findViewById(R.id.xbuscar_edad_cliente) as TextView
            EDAD_CLIENTE.text=contac.Edad_cliente.toString()

        }
    }

}