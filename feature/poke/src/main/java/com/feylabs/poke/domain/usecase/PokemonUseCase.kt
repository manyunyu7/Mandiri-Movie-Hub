package com.feylabs.poke.domain.usecase

import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.poke.domain.uimodel.PokemonDetailUiModel
import com.feylabs.poke.domain.uimodel.PokemonUiModel
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase {

    fun getPokemon(
        query: String,
    ):Flow<ResponseState<List<PokemonUiModel>>>

    fun getPokemonDetail(
        name:String
    ): Flow<ResponseState<PokemonDetailUiModel>>


}