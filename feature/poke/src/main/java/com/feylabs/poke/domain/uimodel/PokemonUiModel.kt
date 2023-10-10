package com.feylabs.poke.domain.uimodel

data class PokemonUiModel(
    val name: String,
    val url: String
) {
    fun getImage(): String {
        // Extract the Pokemon ID from the URL
        val pokemonId = url.split("/").last()
        // Construct the image URL
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonId.png"
    }
}