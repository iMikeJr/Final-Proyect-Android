package com.example.proyect.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyect.Adaptador_recycler_agregar
import com.example.proyect.R
import com.example.proyect.recycler_agregar
import kotlinx.android.synthetic.main.activity_recycler_agregar.*

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    /**DECLARACION DE LOS FRAGMENTS**/
    lateinit var fragmentAgregar: fr_agregar
    lateinit var fragmentBorrar: fr_borrar
    lateinit var fragmentSearch: fr_buscar
    lateinit var fragmentlist: fr_listar
    lateinit var fragmentActualizar: fr_actualizar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        /**declaracion de variables para su uso posterior*/

        val agregar: ImageView = root.findViewById(R.id.AgregarHome)
        val borrar: ImageView = root.findViewById(R.id.BorrarHome)
        val actualizar: ImageView = root.findViewById(R.id.ActualizarHome)
        val buscar: ImageView = root.findViewById(R.id.BuscarHome)
        val listar: ImageView = root.findViewById(R.id.ListarHome)

        homeViewModel.text.observe(viewLifecycleOwner, Observer {


            /**Listener para la funcion agregar**/
            agregar.setOnClickListener {
                fragmentAgregar = fr_agregar()
                val supportFragmentManager = fragmentManager
                supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.nav_host_fragment, fragmentAgregar)
                    ?.addToBackStack(null)
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()

            }

            /**Listener para la funcion de borrar**/
            borrar.setOnClickListener {
                fragmentBorrar = fr_borrar()
                val supportFragmentManager = fragmentManager
                supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.nav_host_fragment, fragmentBorrar)
                    ?.addToBackStack(null)
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
            }

            /**Listener para la funcion de actualizar**/
            actualizar.setOnClickListener {
                fragmentActualizar = fr_actualizar()
                val supportFragmentManager = fragmentManager
                supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.nav_host_fragment, fragmentActualizar)
                    ?.addToBackStack(null)
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
            }

            /**Listener para la funcion de buscar**/
            buscar.setOnClickListener {
                fragmentSearch = fr_buscar()
                val supportFragmentManager = fragmentManager
                supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.nav_host_fragment, fragmentSearch)
                    ?.addToBackStack(null)
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
            }

            /**Listener para la funcion de listar**/
            listar.setOnClickListener {
                fragmentlist = fr_listar()
                val supportFragmentManager = fragmentManager
                supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.nav_host_fragment, fragmentlist)
                    ?.addToBackStack(null)
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
            }
        })

        return root
    }

}
