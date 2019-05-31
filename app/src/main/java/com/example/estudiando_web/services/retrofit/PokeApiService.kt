package com.example.estudiando_web.services.retrofit

import com.example.estudiando_web.database.entities.PokeApiPokemon
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val POKEMON_API_BASE_URL ="https://pokeapi.co/api/v2/"

interface PokeApiService {

    @GET("pokemon/{pokemon}/")
    fun getPokemons(@Path("pokemon") pokemon: String):Deferred<Response<List<PokeApiPokemon>>>

    companion object {
        fun getRetrofit(): PokeApiService {

            return Retrofit.Builder()
                    .baseUrl(POKEMON_API_BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build().create(PokeApiService::class.java)

        }
    }
}