package com.example.proyectotfg_prueba_groovy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radarChart = findViewById<RadarChart>(R.id.radarChart)

        // Puedes personalizar y configurar tu RadarChart según tus necesidades
        val entries: List<RadarEntry> = listOf(RadarEntry(50f), RadarEntry(30f), RadarEntry(80f), RadarEntry(60f), RadarEntry(40f))

        val dataSet = RadarDataSet(entries, "Label del conjunto de datos")
        val radarData = RadarData(dataSet)

        radarChart.data = radarData
    }
}