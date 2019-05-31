package com.example.estudiando_web.database.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.estudiando_web.database.RoomDB
import com.example.estudiando_web.database.entities.PokeApiPokemon
import com.example.estudiando_web.database.repositories.PokeApiRepository
import kotlinx.coroutines.launch

class PokeApiViewModel(private val app: Application) : AndroidViewModel(app) {

    private val repository: PokeApiRepository

    init {
        val pokeDao = RoomDB.getInstance(app).pokeDao()
        repository = PokeApiRepository(pokeDao)
    }

    fun retrieveRepo(pokemon: String) = viewModelScope.launch {
        this@PokeApiViewModel.nuke()
        val response = repository.retrieveRepoAsync(pokemon).await()

        if(response.isSuccessful) with(response){
            this.body()?.forEach {
                println(it.name)
                this@PokeApiViewModel.insert(it)
            }
        } else with(response) {
            when(this.code()){
                404 -> {
                    Toast.makeText(app, "We did't find that Pokemon", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private suspend fun insert(pokemon: PokeApiPokemon) = repository.insert(pokemon)

    fun getAll(): LiveData<List<PokeApiPokemon>> {
        return repository.getAll()
    }

    private suspend fun nuke()= repository.nuke()

}