package com.example.ud01_2one_more_wine

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSearch =findViewById<Button>(R.id.button)
        buttonSearch.setOnClickListener {
            val spinnerWineTypes = findViewById<Spinner>(R.id.wineType)
            val textChosenWine= findViewById<TextView>(R.id.textChosenWine)
            textChosenWine.text = getWines(spinnerWineTypes.selectedItemId).joinToString(" ")
        }


    }

    fun getWines (id: Long): List<String>{
        when (id){
            0L -> return listOf("Albariño, Moscato, Verdejo")
            1L -> return listOf("Rioja", "Ribera del Duero", "Toro")
            2L -> return listOf("Cabernet", "Franc", "Merlot")
            else -> return listOf()
        }
    }
}