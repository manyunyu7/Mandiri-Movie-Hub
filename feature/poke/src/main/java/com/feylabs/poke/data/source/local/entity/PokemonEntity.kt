package com.feylabs.poke.data.source.local.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "pokemon_items")
data class PokemonEntity(
    @PrimaryKey val name: String = "",
    val url: String = "",
)
