package com.feylabs.feat_ui_home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.movie_genre.domain.uimodel.MovieGenreUIModel
import com.feylabs.movie_genre.domain.usecase.MovieUseCase
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
    private val movieUseCase: MovieUseCase,
    private val pokemonUseCase : PokemonUseCase
) :
    ViewModel() {

    private var _movieGenreListValue = MutableStateFlow(MovieGenreListState())
    val movieGenreListValue: StateFlow<MovieGenreListState> = _movieGenreListValue

    private var _pokemonListValue = MutableStateFlow(PokemonListState())
    val pokemonListValue: StateFlow<PokemonListState> = _pokemonListValue

    fun getData() {
        fetchMovieData(_movieGenreListValue)
    }


    class PokemonListState(
        val isLoading: Boolean = false,
        val movieList: List<PokemonUiModel> = emptyList<PokemonUiModel>(),
        var error: String = ""
    )

    class MovieGenreListState(
        val isLoading: Boolean = false,
        val movieList: List<MovieGenreUIModel> = emptyList<MovieGenreUIModel>(),
        var error: String = ""
    )

    fun getMovie() {
        fetchMovieData(_movieGenreListValue)
        fetchPokemon("")
    }


    private fun fetchPokemon(query:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val state = _pokemonListValue
            pokemonUseCase.getPokemon(query).collect {
                when (it) {
                    is ResponseState.Loading -> state.value = PokemonListState(isLoading = true)
                    is ResponseState.Success -> state.value =
                        PokemonListState(movieList = it.data ?: emptyList())

                    is ResponseState.Error -> state.value = PokemonListState(
                        isLoading = false,
                        error = it.errorResponse?.errorMessage.toString()
                    )
                }
            }
        }
    }

    private fun fetchMovieData(state: MutableStateFlow<MovieGenreListState>) {
        viewModelScope.launch(Dispatchers.IO) {
            movieUseCase.getMovieGenre().collect {
                when (it) {
                    is ResponseState.Loading -> state.value = MovieGenreListState(isLoading = true)
                    is ResponseState.Success -> state.value =
                        MovieGenreListState(movieList = it.data ?: emptyList())

                    is ResponseState.Error -> state.value = MovieGenreListState(
                        isLoading = false,
                        error = it.errorResponse?.errorMessage.toString()
                    )
                }
            }
        }
    }


}

