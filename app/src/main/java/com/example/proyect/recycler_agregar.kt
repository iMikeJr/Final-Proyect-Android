package com.example.proyect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_agregar.*


class recycler_agregar : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<Adaptador_recycler_agregar.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_agregar)

        layoutManager = LinearLayoutManager(this)
        recyclerview_agregar.layoutManager = layoutManager
        adapter = Adaptador_recycler_agregar()
        recyclerview_agregar?.adapter = adapter

    }
}