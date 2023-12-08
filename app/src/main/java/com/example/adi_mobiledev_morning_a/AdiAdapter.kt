package com.example.adi_mobiledev_morning_a

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdiAdapter(val dataAdi: List<ResultsItem>): RecyclerView.Adapter<AdiAdapter.MyViewHolder>() {
    class MyViewHolder (view: View): RecyclerView.ViewHolder(view){
        val imgAdi = view.findViewById<ImageView>(R.id.item_image_adi)
        val nameAdi = view.findViewById<TextView>(R.id.item_name_adi)
        val statusAdi = view.findViewById<TextView>(R.id.item_status_adi)
        val speciesAdi = view.findViewById<TextView>(R.id.item_species_adi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataAdi.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameAdi.text = dataAdi[position].name
        holder.statusAdi.text = dataAdi[position].status
        holder.speciesAdi.text = dataAdi[position].species

        Glide.with(holder.imgAdi)
            .load(dataAdi[position].image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgAdi)

        holder.itemView.setOnClickListener {
            val name = dataAdi[position].name
            Toast.makeText(holder.itemView.context,"${name}", Toast.LENGTH_SHORT).show()
        }
    }
}