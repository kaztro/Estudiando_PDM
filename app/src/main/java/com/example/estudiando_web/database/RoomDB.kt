package com.example.estudiando_web.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.estudiando_web.database.daos.PokeApiDao
import com.example.estudiando_web.database.entities.PokeApiPokemon

@Database(entities = [PokeApiPokemon::class], version = 1, exportSchema = false)
public abstract class RoomDB :RoomDatabase() {

    abstract fun pokeDao(): PokeApiDao

    companion object {
        @Volatile
        private var INSTANCE:RoomDB? = null

        fun getInstance(
            context: Context
        ): RoomDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "Poke_Database")
                    .build()
                INSTANCE=instance
                return instance
            }

        }
    }

}