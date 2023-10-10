package com.feylabs.feat_ui_home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.poke.domain.uimodel.PokemonUiModel
import com.feylabs.poke.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SnipsHomeViewModel @Inject constructor(
    private val pokemonUseCase : PokemonUseCase
) :
    ViewModel() {

    private var _pokemonListValue = MutableStateFlow(PokemonListState())
    val pokemonListValue: StateFlow<PokemonListState> = _pokemonListValue


    class PokemonListState(
        val isLoading: Boolean = false,
        val list: List<PokemonUiModel> = emptyList<PokemonUiModel>(),
        var error: String = ""
    )


    fun fetchPokemon(query:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val state = _pokemonListValue
            pokemonUseCase.getPokemon(query).collect {
                when (it) {
                    is ResponseState.Loading -> state.value = PokemonListState(isLoading = true)
                    is ResponseState.Success -> state.value =
                        PokemonListState(list = it.data ?: emptyList())

                    is ResponseState.Error -> state.value = PokemonListState(
                        isLoading = false,
                        error = it.errorResponse?.errorMessage.toString()
                    )
                }
            }
        }
    }


}

