package com.feylabs.poke.domain.interactor

import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.poke.domain.repository.PokemonRepository
import com.feylabs.poke.domain.uimodel.PokemonDetailUiModel
import com.feylabs.poke.domain.uimodel.PokemonUiModel
import com.feylabs.poke.domain.usecase.PokemonUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonInteractor @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : PokemonUseCase {


    override fun getPokemon(query: String): Flow<ResponseState<List<PokemonUiModel>>> {
        return pokemonRepository.getPokemon(
            query
        )
    }

    override fun getPokemonDetail(name: String): Flow<ResponseState<PokemonDetailUiModel>> {
        return pokemonRepository.getDetailPokemon(name)
    }


}