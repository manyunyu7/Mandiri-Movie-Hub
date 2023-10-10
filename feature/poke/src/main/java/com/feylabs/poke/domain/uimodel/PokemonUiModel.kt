package com.feylabs.poke.domain.uimodel

import timber.log.Timber

data class PokemonUiModel(
    val name: String,
    val url: String
) {
    fun getImage(): String {
        // Extract the Pokemon ID from the URL using string manipulation
        val parts = url.split("/")
        val pokemonId = parts[parts.size - 2]

        // Construct the image URL
        val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonId.png"

        Timber.d("121B $imageUrl")
        return imageUrl
    }
}