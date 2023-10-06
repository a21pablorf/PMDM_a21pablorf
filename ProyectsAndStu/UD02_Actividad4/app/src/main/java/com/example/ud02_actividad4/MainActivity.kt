package com.example.ud02_actividad4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var salida=findViewById<TextView>(R.id.salida)
        var boton=findViewById<Button>(R.id.boton)

        boton.setOnClickListener { salida.setText("Lamando a juan perez") }
    }
}