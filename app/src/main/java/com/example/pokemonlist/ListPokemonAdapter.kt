package com.example.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPokemonAdapter(private val listPokemon: ArrayList<Pokemon>)
    : RecyclerView.Adapter<ListPokemonAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.img_item)
        val type : TextView = itemView.findViewById(R.id.tv_type)
        val name : TextView = itemView.findViewById(R.id.tv_pokemon_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view :View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row_pokemon, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPokemon.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, type,desc, photo) =  listPokemon[position]
        holder.imgPhoto.setImageResource(photo)
        holder.name.text = name
        holder.type.text = type

    }
}