package com.example.proyect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adaptador_recycler_listar_cliente (val listaClientes : ArrayList<BDContactModel_cliente>): RecyclerView.Adapter<adaptador_recycler_listar_cliente.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adaptador_recycler_listar_cliente.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.modelo_listar_cliente,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listaClientes.size
    }

    override fun onBindViewHolder(holder: adaptador_recycler_listar_cliente.ViewHolder, position: Int) {
        holder.bindItems(listaClientes[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(contac:BDContactModel_cliente){

            val ID_CLIENTE=itemView.findViewById(R.id.xID_cliente) as TextView
            ID_CLIENTE.text=contac.ID_cliente.toString()

            val NOMBRE_CLIENTE=itemView.findViewById(R.id.xnombre_cliente) as TextView
            NOMBRE_CLIENTE.text=contac.Nombre_cliente

            val CORREO_CLIENTE=itemView.findViewById(R.id.xcorreo_cliente) as TextView
            CORREO_CLIENTE.text=contac.Correo_cliente

            val TELEFONO_CLIENTE=itemView.findViewById(R.id.xtelefono_cliente) as TextView
            TELEFONO_CLIENTE.text=contac.Telefono_cliente.toString()

            val EDAD_CLIENTE=itemView.findViewById(R.id.xedad_cliente) as TextView
            EDAD_CLIENTE.text=contac.Edad_cliente.toString()

        }
    }


}