package com.example.ud04_1_chatapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hacer nuestra barra , la principal
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Host de navegacion(grafo asociado)
        //navHostFragment sería nuestro FragmentView(HostDeNavegacion)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //Configuracion de la barra de navegacion
        var builderApp = AppBarConfiguration.Builder(navController.graph)
        var configurationApp = builderApp.build()
        toolbar.setupWithNavController(navController, configurationApp)

        //BottomBar
        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomBar.setupWithNavController(navController)

        //Panel Lateral
        val lateralPane = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView=findViewById<NavigationView>(R.id.nav_view)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController=findNavController(R.id.nav_host_fragment)
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
    }
}