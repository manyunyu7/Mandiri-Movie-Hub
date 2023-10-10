package com.feylabs.poke.data

import com.feylabs.poke.data.source.remote.dto.pokemon.PokemonDetailResponseDto
import com.feylabs.poke.data.source.remote.dto.pokemon.PokemonResponseDto
import com.feylabs.poke.data.source.remote.service.PokemonApi
import com.feylabs.poke.di.PokemonModule
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    @PokemonModule.RetrofitSnips private val api: PokemonApi
) {

    suspend fun getPokemon(
    ): Response<PokemonResponseDto> {
        return api.getPokemon()
    }

    suspend fun getPokemonDetail(
        name:String
    ): Response<PokemonDetailResponseDto> {
        return api.getPokemonDetail(name = name)
    }




}