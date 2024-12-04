package com.example.aplicacion3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FarmaciaAdapter(
    private val onClick: (Farmacia) -> Unit
) : RecyclerView.Adapter<FarmaciaAdapter.FarmaciaViewHolder>() {

    private val farmacias = mutableListOf<Farmacia>()

    fun submitList(newList: List<Farmacia>) {
        farmacias.clear()
        farmacias.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmaciaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_farmacia, parent, false)
        return FarmaciaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FarmaciaViewHolder, position: Int) {
        holder.bind(farmacias[position])
    }

    override fun getItemCount() = farmacias.size

    inner class FarmaciaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val icon: ImageView = itemView.findViewById(R.id.icon)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val phone: TextView = itemView.findViewById(R.id.phone)

        fun bind(farmacia: Farmacia) {
            name.text = farmacia.nombre
            phone.text = farmacia.telefono
            itemView.setOnClickListener { onClick(farmacia) }
        }
    }
}