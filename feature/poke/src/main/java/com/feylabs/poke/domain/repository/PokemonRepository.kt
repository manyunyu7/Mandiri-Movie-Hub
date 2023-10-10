package com.feylabs.poke.domain.repository

import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.poke.domain.uimodel.PokemonUiModel
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemon(
        query:String,
    ): Flow<ResponseState<List<PokemonUiModel>>>


}