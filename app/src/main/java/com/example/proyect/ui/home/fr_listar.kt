package com.example.proyect.ui.home

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyect.Adaptador_recycler_buscar
import com.example.proyect.Adaptador_recycler_listar
import com.example.proyect.R

class fr_listar : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**Codigo importante a considerar**/
        val view = inflater.inflate(R.layout.activity_recycler_listar, container, false)
        var alldataborrar = view?.findViewById<RecyclerView>(R.id.recyclerview_listar)

        if (alldataborrar != null) {
            alldataborrar.layoutManager =
                LinearLayoutManager(view?.context, LinearLayoutManager.VERTICAL, false)
        }

        // Inflate the layout for this fragment


        val adapter = Adaptador_recycler_listar()
        alldataborrar?.adapter = adapter
        return view
        /**Fin del codigo importante**/
    }
}