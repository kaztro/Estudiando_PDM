package com.example.estudiando_web.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.estudiando_web.database.daos.PokeApiDao
import com.example.estudiando_web.database.entities.PokeApiPokemon
import com.example.estudiando_web.services.retrofit.PokeApiService
import kotlinx.coroutines.Deferred
import retrofit2.Response

class PokeApiRepository(private val pokeDao: PokeApiDao) {

    fun retrieveRepoAsync(pokemon: String): Deferred<Response<List<PokeApiPokemon>>> {
        return PokeApiService.getRetrofit().getPokemons(pokemon)
    }

    @WorkerThread
    suspend fun insert(pokemon:PokeApiPokemon){
        pokeDao.insert(pokemon)
    }

    fun getAll(): LiveData<List<PokeApiPokemon>> {
        return pokeDao.getAllThePokemons()
    }

    @WorkerThread
    suspend fun nuke(){
        return pokeDao.nukeTable()
    }

}