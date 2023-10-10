package com.feylabs.poke.data.source.local.dao

import androidx.room.*
import com.feylabs.poke.data.source.local.entity.PokemonEntity

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPokemon(items: List<PokemonEntity?>)

    @Query("SELECT * FROM pokemon_items WHERE name LIKE :name")
    fun findPokemonByName(name: String): List<PokemonEntity>

}