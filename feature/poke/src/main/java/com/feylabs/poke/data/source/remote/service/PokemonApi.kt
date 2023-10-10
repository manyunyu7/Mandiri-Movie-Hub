package com.feylabs.poke.data.source.remote.service

import com.feylabs.poke.data.source.remote.dto.pokemon.PokemonDetailResponseDto
import com.feylabs.poke.data.source.remote.dto.pokemon.PokemonResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonApi {

    @GET("api/v2/pokemon?limit=20000")
    suspend fun getPokemon(): Response<PokemonResponseDto>

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String,
    ): Response<PokemonDetailResponseDto>


}