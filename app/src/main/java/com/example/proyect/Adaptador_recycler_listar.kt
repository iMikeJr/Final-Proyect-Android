package com.example.proyect

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.modelo_listar.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.proyect.recycler_listar__empleado

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class Adaptador_recycler_listar : RecyclerView.Adapter<Adaptador_recycler_listar.ViewHolder>() {

    lateinit var recyclerListarEmpleado: recycler_listar__empleado

    val ListarElementosBD = arrayOf(
        "Servicio", "Empleado", "Proyecto",
        "Cliente"
    )

    val imagesListar = arrayOf(
        R.drawable.addserviciorecycler, R.drawable.addemployerecycler,
        R.drawable.addproyectorecycler, R.drawable.userelementrecycler
    )


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): Adaptador_recycler_listar.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.modelo_listar, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return ListarElementosBD.size
    }

    override fun onBindViewHolder(holder: Adaptador_recycler_listar.ViewHolder, position: Int) {
        holder.itemView.imagelist.setImageResource(imagesListar[position])
        holder.itemView.elementlist.text = ListarElementosBD[position]
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagenlist: ImageView
        var elementlist: TextView

        init {
            imagenlist = itemView.findViewById(R.id.imagelist)
            elementlist = itemView.findViewById(R.id.elementlist)


            itemView.setOnClickListener() { v: View ->
                val nContext = v.context
                var position: Int = adapterPosition

                when (position) {
                    0 -> {
                        val intent = Intent(nContext, recycler_listar_servicios::class.java)
                        nContext.startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(nContext, recycler_listar__empleado::class.java)
                        nContext.startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(nContext, recycler_listar_proyecto::class.java)
                        nContext.startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(nContext, recycler_listar_cliente::class.java)
                        nContext.startActivity(intent)
                    }
                }

            }
        }
    }

}