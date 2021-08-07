package com.example.proyect

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.modelo_agregar.view.*
import kotlinx.android.synthetic.main.modelo_borrar.view.*

class Adaptador_recycler_borrar : RecyclerView.Adapter<Adaptador_recycler_borrar.ViewHolder>() {


    val BorrarElementosBD = arrayOf(
        "Empleado", "Servicio", "Cliente",
        "Proyecto"
    )

    val imagesBorrar = arrayOf(
        R.drawable.addemployerecycler, R.drawable.addserviciorecycler,
        R.drawable.userelementrecycler, R.drawable.addproyectorecycler
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adaptador_recycler_borrar.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.modelo_borrar, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return BorrarElementosBD.size
    }

    override fun onBindViewHolder(holder: Adaptador_recycler_borrar.ViewHolder, position: Int) {
        holder.itemView.imagedelete.setImageResource(imagesBorrar[position])
        holder.itemView.elementdelete.text = BorrarElementosBD[position]
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagendelete: ImageView
        var elementdelete: TextView

        init {
            imagendelete = itemView.findViewById(R.id.imagedelete)
            elementdelete = itemView.findViewById(R.id.elementdelete)


            itemView.setOnClickListener() { v: View ->
                val nContext = v.context
                var position: Int = adapterPosition

                when (position) {
                    0 -> {
                        val intent = Intent(nContext, form_borrar_empleado::class.java)
                        nContext.startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(nContext, form_borrar_servicio::class.java)
                        nContext.startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(nContext, form_borrar_cliente::class.java)
                        nContext.startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(nContext, form_borrar_proyecto::class.java)
                        nContext.startActivity(intent)
                    }
                }

            }
        }
    }

}