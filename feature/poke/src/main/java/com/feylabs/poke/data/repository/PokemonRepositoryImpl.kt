package com.feylabs.poke.data.repository

import android.net.ConnectivityManager
import com.feylabs.core.helper.error.ErrorResponse
import com.feylabs.core.helper.network.NetworkInfo
import com.feylabs.core.helper.wrapper.ResponseState
import com.feylabs.poke.data.RemoteDataSource
import com.feylabs.poke.data.mapper.Mapper.toPokemonEntity
import com.feylabs.poke.data.mapper.Mapper.toPokemonUiModel
import com.feylabs.poke.data.source.local.dao.PokemonDao
import com.feylabs.poke.di.PokemonModule.ConnectivityManagerSnips
import com.feylabs.poke.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @ConnectivityManagerSnips private val connectivityManager: ConnectivityManager,
    private val pokeDb: PokemonDao,
) : PokemonRepository {


    override fun getPokemon(query: String) =
        flow {
            emit(ResponseState.Loading())

            if (!NetworkInfo.isOnline(connectivityManager)) {
                val errorMessage = "Tidak Ada Koneksi Internet"
                val data = pokeDb.findPokemonByName(query).map { it.toPokemonUiModel() }
                emit(ResponseState.Error(ErrorResponse(errorMessage = errorMessage)))
                delay(1000)
                emit(ResponseState.Success(data))
                return@flow
            }

            try {
                val response = remoteDataSource.getPokemon()

                if (response.isSuccessful) {
                    response.body()?.results?.map { it.toPokemonEntity() }?.let {
                        pokeDb.insertAllPokemon(it)
                    }
                    delay(1000)
                    val data = pokeDb.findPokemonByName(query).map { it.toPokemonUiModel() }
                    emit(ResponseState.Success(data))
                } else {
                    val errorResponse = ErrorResponse(response.message().toString())
                    emit(ResponseState.Error(errorResponse))
                }

            } catch (e: Exception) {
                val errorMessage = "Tidak Ada Koneksi Internet"
                val data = pokeDb.findPokemonByName(query).map { it.toPokemonUiModel() }
                emit(ResponseState.Error(ErrorResponse(errorMessage = errorMessage)))
                delay(1000)
                emit(ResponseState.Success(data))
            }
        }.flowOn(Dispatchers.IO)



}



