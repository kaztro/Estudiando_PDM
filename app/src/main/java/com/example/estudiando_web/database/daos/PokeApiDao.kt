package com.example.estudiando_web.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.estudiando_web.database.entities.PokeApiPokemon

@Dao
interface PokeApiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon:PokeApiPokemon)

    @Query("SELECT*FROM pokemons")
    fun getAllThePokemons(): LiveData<List<PokeApiPokemon>>

    @Query("DELETE FROM pokemons")
    suspend fun nukeTable()
}