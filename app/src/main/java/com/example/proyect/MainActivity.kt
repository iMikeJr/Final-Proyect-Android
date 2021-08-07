package com.example.proyect

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.ui.AppBarConfiguration
import com.example.proyect.ui.home.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var fragmentAgregar: fr_agregar
    lateinit var fragmentBorrar: fr_borrar
    lateinit var fragmentSearch: fr_buscar
    lateinit var fragmentlist: fr_listar
    lateinit var fragmentActualizar: fr_actualizar

    /**Declaracion de las variables globales**/
    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var drawerLayout: DrawerLayout

    //fragment para home
    lateinit var fragmenthome: HomeFragment

    /**Final de la declaracion**/
    override fun onCreate(savedInstanceState: Bundle?){
        /**begining oncreate**/

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        navView.itemIconTintList = null

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    /**end oncreate**/
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    //codigo para el nav bar de la izquierda
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Agregar_drawer -> {
                fragmentAgregar = fr_agregar()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragmentAgregar)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.Eliminar_drawer -> {
                fragmentBorrar = fr_borrar()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragmentBorrar)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.Actualizar_drawer -> {
                fragmentActualizar = fr_actualizar()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragmentActualizar)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.Buscar_drawer -> {
                fragmentSearch = fr_buscar()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragmentSearch)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.Listar_drawer -> {

                fragmentlist = fr_listar()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragmentlist)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.Sugerencias_drawer -> {
                Toast.makeText(
                    this,
                    "Escoge la app GMAIL para enviar tu sugerencia",
                    Toast.LENGTH_LONG
                ).show()

                val intent: Intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_EMAIL, "miguel306027@gmail.com")
                startActivity(Intent.createChooser(intent, "Compartir usando"))
            }

            R.id.acercade_drawer -> {
                inflate()
            }

        }
        return true
    }

    private fun inflate() {
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.acercade,null,false)
        val toast = Toast(applicationContext)
        toast.view = view
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }
}