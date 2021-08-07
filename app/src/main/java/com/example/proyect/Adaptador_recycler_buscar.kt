package com.example.proyect

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.modelo_buscar.view.*


class Adaptador_recycler_buscar : RecyclerView.Adapter<Adaptador_recycler_buscar.ViewHolder>() {


    val BuscarElementosBD = arrayOf(
        "Empleado", "Servicio", "Cliente",
        "Proyecto"
    )

    val imagesBuscar = arrayOf(
        R.drawable.addemployerecycler, R.drawable.addserviciorecycler,
        R.drawable.userelementrecycler, R.drawable.addproyectorecycler
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adaptador_recycler_buscar.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.modelo_buscar, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return BuscarElementosBD.size
    }

    override fun onBindViewHolder(holder: Adaptador_recycler_buscar.ViewHolder, position: Int) {
        holder.itemView.imagesearch.setImageResource(imagesBuscar[position])
        holder.itemView.elementsearch.text = BuscarElementosBD[position]
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagensearch: ImageView
        var elementsearch: TextView

        init {
            imagensearch = itemView.findViewById(R.id.imagesearch)
            elementsearch = itemView.findViewById(R.id.elementsearch)


            itemView.setOnClickListener() { v: View ->
                val nContext = v.context
                var position: Int = adapterPosition

                when (position) {
                    0 -> {
                        val intent = Intent(nContext, recycler_buscar_empleado::class.java)
                        nContext.startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(nContext, recycler_buscar_servicio::class.java)
                        nContext.startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(nContext, recycler_buscar_cliente::class.java)
                        nContext.startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(nContext, recycler_buscar_proyecto::class.java)
                        nContext.startActivity(intent)
                    }
                }

            }
        }
    }
}