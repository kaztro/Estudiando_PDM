package com.example.estudiando_web.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "Pokemons")
data class PokeApiPokemon (

    @PrimaryKey
    @field:Json(name = "id")
    val id: Int,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "base_experience")
    val base_experience: Int,

    @field:Json(name = "height")
    val height: Int,

    @field:Json(name = "is_default")
    val isDefault: Boolean,

    @field:Json(name = "order")
    val order: Int,

    @field:Json(name = "weight")
    val weight: Integer
)