package com.feylabs.poke.di

import com.feylabs.poke.data.repository.PokemonRepositoryImpl
import com.feylabs.poke.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PokemonRepositoryModule {

    @Binds
    abstract fun bindRepository(luminaRepository: PokemonRepositoryImpl): PokemonRepository
}