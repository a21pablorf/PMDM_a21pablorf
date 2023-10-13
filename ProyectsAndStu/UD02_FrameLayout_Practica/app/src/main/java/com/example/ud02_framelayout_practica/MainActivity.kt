package com.example.ud02_framelayout_practica

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ourense=findViewById<ImageView>(R.id.ourense)
        var santiago=findViewById<ImageView>(R.id.santiago)
        var texto=findViewById<TextView>(R.id.salida)

        ourense.setOnClickListener { texto.setText("La ciudad de Ourense tiene termas") }
        santiago.setOnClickListener { texto.setText("Santiago tiene muchos peregrinos") }
    }
}