package com.feylabs.poke.data.mapper


import com.feylabs.poke.data.source.local.entity.PokemonEntity
import com.feylabs.poke.data.source.remote.dto.pokemon.PokemonResponseDto
import com.feylabs.poke.domain.uimodel.PokemonUiModel

object Mapper {


    fun PokemonResponseDto.PokemonResponseItemDto.toPokemonEntity(): PokemonEntity {
        return PokemonEntity(
            url = this.url.orEmpty(),
            name = this.name.orEmpty()
        )
    }

    fun PokemonEntity.toPokemonUiModel(): PokemonUiModel {
        return PokemonUiModel(
            url = this.url.orEmpty(),
            name = this.name.orEmpty()
        )
    }



}