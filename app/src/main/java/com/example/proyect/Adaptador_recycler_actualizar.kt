package com.example.proyect
import android.content.Intent
import android.view.View
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.modelo_actualizar.*
import kotlinx.android.synthetic.main.modelo_actualizar.view.*
import kotlinx.android.synthetic.main.modelo_agregar.view.*

class Adaptador_recycler_actualizar :
    RecyclerView.Adapter<Adaptador_recycler_actualizar.ViewHolder>() {
    val UpdateElementosBD = arrayOf(
        "Cliente", "Proyecto", "Servicio",
        "Empleado"
    )

    val imagesUpdate = arrayOf(
        R.drawable.userelementrecycler, R.drawable.addproyectorecycler,
        R.drawable.addserviciorecycler, R.drawable.addemployerecycler
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adaptador_recycler_actualizar.ViewHolder {

        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.modelo_actualizar, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return UpdateElementosBD.size
    }

    override fun onBindViewHolder(holder: Adaptador_recycler_actualizar.ViewHolder, position: Int) {
        holder.itemView.imagesupdate.setImageResource(imagesUpdate[position])
        holder.itemView.elementupdate.text = UpdateElementosBD[position]
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagenupdate: ImageView
        var nombreupdate: TextView

        init {
            imagenupdate = itemView.findViewById(R.id.imagesupdate)
            nombreupdate = itemView.findViewById(R.id.elementupdate)


            itemView.setOnClickListener() { v: View ->
                val nContext = v.context
                var position: Int = adapterPosition

                when (position) {
                    0 -> {
                        val intent = Intent(nContext,form_actualizar_cliente::class.java)
                        nContext.startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(nContext,form_actualizar_proyecto::class.java)
                        nContext.startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(nContext,form_actualizar_servicio::class.java)
                        nContext.startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(nContext,form_actualizar_empleado::class.java)
                        nContext.startActivity(intent)
                    }
                }

            }
        }

    }
}