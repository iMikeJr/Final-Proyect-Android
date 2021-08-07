package com.example.proyect

import android.content.Intent
import android.view.View
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.modelo_agregar.view.*

class Adaptador_recycler_agregar : RecyclerView.Adapter<Adaptador_recycler_agregar.ViewHolder>() {

    val AgregarElementosBD = arrayOf(
        "Empleado", "Servicio", "Cliente",
        "Proyecto"
    )

    val images = arrayOf(
        R.drawable.addemployerecycler, R.drawable.addserviciorecycler,
        R.drawable.userelementrecycler, R.drawable.addproyectorecycler
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adaptador_recycler_agregar.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.modelo_agregar, parent, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return AgregarElementosBD.size
    }

    override fun onBindViewHolder(holder: Adaptador_recycler_agregar.ViewHolder, position: Int) {
        holder.itemView.imageADD.setImageResource(images[position])
        holder.itemView.element.text = AgregarElementosBD[position]

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagenn: ImageView
        var nombre: TextView

        init {
            imagenn = itemView.findViewById(R.id.imageADD)
            nombre = itemView.findViewById(R.id.element)


            itemView.setOnClickListener() { v: View ->
                val nContext = v.context
                var position: Int = adapterPosition

                when (position) {
                    0 -> {
                        val intent = Intent(nContext,form_Agregar_empleado::class.java)
                        nContext.startActivity(intent)

                    }
                    1 -> {
                        val intent = Intent(nContext,form_agregar_servicio::class.java)
                        nContext.startActivity(intent)
                    }
                    2->{
                        val intent = Intent(nContext,form_agregar_cliente::class.java)
                        nContext.startActivity(intent)
                    }
                    3->{
                        val intent = Intent(nContext,form_agregar_proyecto::class.java)
                        nContext.startActivity(intent)
                    }
                }

            }
        }

    }
}