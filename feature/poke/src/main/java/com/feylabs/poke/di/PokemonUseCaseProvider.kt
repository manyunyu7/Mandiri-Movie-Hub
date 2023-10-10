package com.feylabs.poke.di

import com.feylabs.poke.domain.interactor.PokemonInteractor
import com.feylabs.poke.domain.usecase.PokemonUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonUseCaseProvider {
    @Binds
    abstract fun snipUseCaseProvider(useCase: PokemonInteractor): PokemonUseCase
}