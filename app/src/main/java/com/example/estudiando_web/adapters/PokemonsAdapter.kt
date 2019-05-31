package com.example.estudiando_web.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.estudiando_web.R
import com.example.estudiando_web.database.entities.PokeApiPokemon
import kotlinx.android.synthetic.main.poke_cardview.view.*

class PokemonsAdapter(var pokemons: List<PokeApiPokemon>) : RecyclerView.Adapter<PokemonsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poke_cardview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pokemons[position])
    }

    fun updateList(newPokemons:List<PokeApiPokemon>){
        newPokemons.forEach{
            println("--Insertado--")
        }
        this.pokemons = newPokemons
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(repo: PokeApiPokemon) = with(itemView) {
            this.poke_name.text = repo.name
        }

    }

}