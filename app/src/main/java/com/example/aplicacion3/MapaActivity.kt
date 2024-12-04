package com.example.aplicacion3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MapaActivity : AppCompatActivity() {

    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Configuration.getInstance().load(this, getSharedPreferences("osmdroid", MODE_PRIVATE))
        setContentView(R.layout.activity_mapa)

        map = findViewById(R.id.map)
        map.setMultiTouchControls(true)
        map.controller.setZoom(15.0)

        val farmaciasJson = intent.getStringExtra("farmacias")
        val farmacias: List<Farmacia> = Gson().fromJson(farmaciasJson, object : TypeToken<List<Farmacia>>() {}.type)
        mostrarFarmaciasEnMapa(farmacias)
    }

    private fun mostrarFarmaciasEnMapa(farmacias: List<Farmacia>) {
        for (farmacia in farmacias) {
            val point = GeoPoint(farmacia.latitud, farmacia.longitud)
            val marker = Marker(map)
            marker.position = point
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            marker.title = farmacia.nombre
            map.overlays.add(marker)
        }
        if (farmacias.isNotEmpty()) {
            val firstFarmacia = farmacias[0]
            val startPoint = GeoPoint(firstFarmacia.latitud, firstFarmacia.longitud)
            map.controller.setCenter(startPoint)
        }
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}