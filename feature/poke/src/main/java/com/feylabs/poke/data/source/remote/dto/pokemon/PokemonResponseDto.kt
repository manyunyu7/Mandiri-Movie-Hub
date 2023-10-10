package com.feylabs.poke.data.source.remote.dto.pokemon


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class PokemonResponseDto(
    @SerializedName("count")
    @Expose
    val count: Int? = null,
    @SerializedName("next")
    @Expose
    val next: Any? = null,
    @SerializedName("previous")
    @Expose
    val previous: Any? = null,
    @SerializedName("results")
    @Expose
    val results: List<PokemonResponseItemDto> = listOf()
) {
    data class PokemonResponseItemDto(
        @SerializedName("name")
        @Expose
        val name: String? = null,
        @SerializedName("url")
        @Expose
        val url: String? = null
    )
}