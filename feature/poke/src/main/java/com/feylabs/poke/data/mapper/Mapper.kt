package com.feylabs.poke.data.mapper


import com.feylabs.poke.data.source.local.entity.PokemonEntity
import com.feylabs.poke.data.source.remote.dto.pokemon.PokemonDetailResponseDto
import com.feylabs.poke.data.source.remote.dto.pokemon.PokemonResponseDto
import com.feylabs.poke.domain.uimodel.PokemonDetailUiModel
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

    fun PokemonDetailResponseDto.toPokemonDetailUiModel(): PokemonDetailUiModel {
        return PokemonDetailUiModel(
            name = this.name.orEmpty(),
            url = "",
            spriteFrontDefault = sprites?.frontDefault.orEmpty(),
            abilities = getAbilities(abilities),
            backdrop = this.sprites?.other?.home?.frontDefault.orEmpty(),
            stats = getStats(this.stats),
            types = getTypes(this.types)
        )
    }

    private fun getTypes(types: List<PokemonDetailResponseDto.Type?>?): String {
        val text = StringBuilder()

        types?.forEachIndexed { index, ability ->
            ability?.let {
                text.append(it.type?.name.orEmpty())
                if (index < types.size - 1) {
                    text.append(",")
                }
            }
        }

        return text.toString()
    }

    private fun getStats(stats: List<PokemonDetailResponseDto.Stat?>?): String {
        val text = StringBuilder()

        stats?.forEachIndexed { index, ability ->
            ability?.let {
                text.append(it.stat?.name.orEmpty())
                if (index < stats.size - 1) {
                    text.append(",")
                }
            }
        }

        return text.toString()
    }

    private fun getAbilities(abilities: List<PokemonDetailResponseDto.Ability?>?): String {
        val text = StringBuilder()

        abilities?.forEachIndexed { index, ability ->
            ability?.let {
                text.append(it.ability?.name.orEmpty())
                if (index < abilities.size - 1) {
                    text.append(",")
                }
            }
        }

        return text.toString()
    }

}