package com.feylabs.feat_ui_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feylabs.core.helper.wrapper.ResponseState.*
import com.feylabs.poke.domain.uimodel.PokemonDetailUiModel
import com.feylabs.poke.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(private val movieUseCase: PokemonUseCase) : ViewModel() {

    private val _pokemonDetailValue = MutableStateFlow(MovieDetailState())
    var pokemonDetailValue: StateFlow<MovieDetailState> = _pokemonDetailValue

    fun getPokemonDetail(pokemonName:String) {
        viewModelScope.launch(Dispatchers.IO) {
            movieUseCase.getPokemonDetail(pokemonName).collect {
                when (it) {
                    is Loading -> {
                        _pokemonDetailValue.value = MovieDetailState(
                            isLoading = true
                        )
                    }
                    is Success -> {
                        _pokemonDetailValue.value = MovieDetailState(
                            data = it.data
                        )
                    }
                    is Error -> {
                        _pokemonDetailValue.value = MovieDetailState(
                            isLoading = false,
                            error = it.errorResponse?.errorMessage.toString()
                        )
                    }
                }
            }
        }

    }
}

class MovieDetailState(
    val isLoading: Boolean = false,
    var error: String = "",
    var data : PokemonDetailUiModel?=null
)