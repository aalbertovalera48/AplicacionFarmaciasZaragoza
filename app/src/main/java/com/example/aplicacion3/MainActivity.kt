package com.example.aplicacion3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var farmaciaAdapter: FarmaciaAdapter
    private lateinit var firebaseHelper: FirebaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        farmaciaAdapter = FarmaciaAdapter { farmacia ->
            val intent = Intent(this, MapaActivity::class.java).apply {
                putExtra("nombre", farmacia.nombre)
                putExtra("latitud", farmacia.latitud)
                putExtra("longitud", farmacia.longitud)
            }
            startActivity(intent)
        }
        recyclerView.adapter = farmaciaAdapter

        firebaseHelper = FirebaseHelper()
        firebaseHelper.obtenerFarmacias { farmacias ->
            farmaciaAdapter.submitList(farmacias)
            val buttonMap: Button = findViewById(R.id.button_map)
            buttonMap.setOnClickListener {
                val intent = Intent(this, MapaActivity::class.java).apply {
                    putExtra("farmacias", Gson().toJson(farmacias))
                }
                startActivity(intent)
            }
        }
    }
}