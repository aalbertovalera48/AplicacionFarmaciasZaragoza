package com.example.aplicacion3

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseHelper {

    private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("farmacias")

    fun obtenerFarmacias(onDataReceived: (List<Farmacia>) -> Unit) {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val farmacias = mutableListOf<Farmacia>()
                for (data in snapshot.children) {
                    val farmacia = data.getValue(Farmacia::class.java)
                    if (farmacia != null) {
                        farmacias.add(farmacia)
                    }
                }
                onDataReceived(farmacias)
            }

            override fun onCancelled(error: DatabaseError) {
                onDataReceived(emptyList())
            }
        })
    }
}