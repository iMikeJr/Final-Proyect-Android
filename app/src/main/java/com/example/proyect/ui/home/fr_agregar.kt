package com.example.proyect.ui.home
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyect.Adaptador_recycler_agregar
import com.example.proyect.R
class fr_agregar : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**Codigo importante a considerar**/
        val view = inflater.inflate(R.layout.activity_recycler_agregar, container, false)
        var alldata = view?.findViewById<RecyclerView>(R.id.recyclerview_agregar)

        if (alldata != null) {
            alldata.layoutManager =
                LinearLayoutManager(view?.context, LinearLayoutManager.VERTICAL, false)
        }
        // Inflate the layout for this fragment
        val adapter = Adaptador_recycler_agregar()
        alldata?.adapter = adapter
        return view
        /**Fin del codigo importante**/
    }
}