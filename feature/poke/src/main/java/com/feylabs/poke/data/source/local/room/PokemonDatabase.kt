package com.feylabs.poke.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.feylabs.poke.data.source.local.dao.PokemonDao
import com.feylabs.poke.data.source.local.entity.PokemonEntity


@Database(
    entities = [PokemonEntity::class], version = 170
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}