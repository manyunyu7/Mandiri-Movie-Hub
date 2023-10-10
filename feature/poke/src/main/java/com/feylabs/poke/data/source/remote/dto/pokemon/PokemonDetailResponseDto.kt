package com.feylabs.poke.data.source.remote.dto.pokemon


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class PokemonDetailResponseDto(
    @SerializedName("abilities")
    @Expose
    val abilities: List<Ability?>? = null,
    @SerializedName("base_experience")
    @Expose
    val baseExperience: Int? = null,
    @SerializedName("forms")
    @Expose
    val forms: List<Form?>? = null,
    @SerializedName("game_indices")
    @Expose
    val gameIndices: List<GameIndice?>? = null,
    @SerializedName("height")
    @Expose
    val height: Int? = null,
    @SerializedName("held_items")
    @Expose
    val heldItems: List<Any?>? = null,
    @SerializedName("id")
    @Expose
    val id: Int? = null,
    @SerializedName("is_default")
    @Expose
    val isDefault: Boolean? = null,
    @SerializedName("location_area_encounters")
    @Expose
    val locationAreaEncounters: String? = null,
    @SerializedName("moves")
    @Expose
    val moves: List<Move?>? = null,
    @SerializedName("name")
    @Expose
    val name: String? = null,
    @SerializedName("order")
    @Expose
    val order: Int? = null,
    @SerializedName("past_types")
    @Expose
    val pastTypes: List<Any?>? = null,
    @SerializedName("species")
    @Expose
    val species: Species? = null,
    @SerializedName("sprites")
    @Expose
    val sprites: Sprites? = null,
    @SerializedName("stats")
    @Expose
    val stats: List<Stat?>? = null,
    @SerializedName("types")
    @Expose
    val types: List<Type?>? = null,
    @SerializedName("weight")
    @Expose
    val weight: Int? = null
) {
    data class Ability(
        @SerializedName("ability")
        @Expose
        val ability: Ability? = null,
        @SerializedName("is_hidden")
        @Expose
        val isHidden: Boolean? = null,
        @SerializedName("slot")
        @Expose
        val slot: Int? = null
    ) {
        data class Ability(
            @SerializedName("name")
            @Expose
            val name: String? = null,
            @SerializedName("url")
            @Expose
            val url: String? = null
        )
    }

    data class Form(
        @SerializedName("name")
        @Expose
        val name: String? = null,
        @SerializedName("url")
        @Expose
        val url: String? = null
    )

    data class GameIndice(
        @SerializedName("game_index")
        @Expose
        val gameIndex: Int? = null,
        @SerializedName("version")
        @Expose
        val version: Version? = null
    ) {
        data class Version(
            @SerializedName("name")
            @Expose
            val name: String? = null,
            @SerializedName("url")
            @Expose
            val url: String? = null
        )
    }

    data class Move(
        @SerializedName("move")
        @Expose
        val move: Move? = null,
        @SerializedName("version_group_details")
        @Expose
        val versionGroupDetails: List<VersionGroupDetail?>? = null
    ) {
        data class Move(
            @SerializedName("name")
            @Expose
            val name: String? = null,
            @SerializedName("url")
            @Expose
            val url: String? = null
        )

        data class VersionGroupDetail(
            @SerializedName("level_learned_at")
            @Expose
            val levelLearnedAt: Int? = null,
            @SerializedName("move_learn_method")
            @Expose
            val moveLearnMethod: MoveLearnMethod? = null,
            @SerializedName("version_group")
            @Expose
            val versionGroup: VersionGroup? = null
        ) {
            data class MoveLearnMethod(
                @SerializedName("name")
                @Expose
                val name: String? = null,
                @SerializedName("url")
                @Expose
                val url: String? = null
            )

            data class VersionGroup(
                @SerializedName("name")
                @Expose
                val name: String? = null,
                @SerializedName("url")
                @Expose
                val url: String? = null
            )
        }
    }

    data class Species(
        @SerializedName("name")
        @Expose
        val name: String? = null,
        @SerializedName("url")
        @Expose
        val url: String? = null
    )

    data class Sprites(
        @SerializedName("back_default")
        @Expose
        val backDefault: String? = null,
        @SerializedName("back_female")
        @Expose
        val backFemale: Any? = null,
        @SerializedName("back_shiny")
        @Expose
        val backShiny: String? = null,
        @SerializedName("back_shiny_female")
        @Expose
        val backShinyFemale: Any? = null,
        @SerializedName("front_default")
        @Expose
        val frontDefault: String? = null,
        @SerializedName("front_female")
        @Expose
        val frontFemale: Any? = null,
        @SerializedName("front_shiny")
        @Expose
        val frontShiny: String? = null,
        @SerializedName("front_shiny_female")
        @Expose
        val frontShinyFemale: Any? = null,
        @SerializedName("other")
        @Expose
        val other: Other? = null,
        @SerializedName("versions")
        @Expose
        val versions: Versions? = null
    ) {
        data class Other(
            @SerializedName("dream_world")
            @Expose
            val dreamWorld: DreamWorld? = null,
            @SerializedName("home")
            @Expose
            val home: Home? = null,
            @SerializedName("official-artwork")
            @Expose
            val officialArtwork: OfficialArtwork? = null
        ) {
            data class DreamWorld(
                @SerializedName("front_default")
                @Expose
                val frontDefault: String? = null,
                @SerializedName("front_female")
                @Expose
                val frontFemale: Any? = null
            )

            data class Home(
                @SerializedName("front_default")
                @Expose
                val frontDefault: String? = null,
                @SerializedName("front_female")
                @Expose
                val frontFemale: Any? = null,
                @SerializedName("front_shiny")
                @Expose
                val frontShiny: String? = null,
                @SerializedName("front_shiny_female")
                @Expose
                val frontShinyFemale: Any? = null
            )

            data class OfficialArtwork(
                @SerializedName("front_default")
                @Expose
                val frontDefault: String? = null,
                @SerializedName("front_shiny")
                @Expose
                val frontShiny: String? = null
            )
        }

        data class Versions(
            @SerializedName("generation-i")
            @Expose
            val generationI: GenerationI? = null,
            @SerializedName("generation-ii")
            @Expose
            val generationIi: GenerationIi? = null,
            @SerializedName("generation-iii")
            @Expose
            val generationIii: GenerationIii? = null,
            @SerializedName("generation-iv")
            @Expose
            val generationIv: GenerationIv? = null,
            @SerializedName("generation-v")
            @Expose
            val generationV: GenerationV? = null,
            @SerializedName("generation-vi")
            @Expose
            val generationVi: GenerationVi? = null,
            @SerializedName("generation-vii")
            @Expose
            val generationVii: GenerationVii? = null,
            @SerializedName("generation-viii")
            @Expose
            val generationViii: GenerationViii? = null
        ) {
            data class GenerationI(
                @SerializedName("red-blue")
                @Expose
                val redBlue: RedBlue? = null,
                @SerializedName("yellow")
                @Expose
                val yellow: Yellow? = null
            ) {
                data class RedBlue(
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_gray")
                    @Expose
                    val backGray: String? = null,
                    @SerializedName("back_transparent")
                    @Expose
                    val backTransparent: String? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_gray")
                    @Expose
                    val frontGray: String? = null,
                    @SerializedName("front_transparent")
                    @Expose
                    val frontTransparent: String? = null
                )

                data class Yellow(
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_gray")
                    @Expose
                    val backGray: String? = null,
                    @SerializedName("back_transparent")
                    @Expose
                    val backTransparent: String? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_gray")
                    @Expose
                    val frontGray: String? = null,
                    @SerializedName("front_transparent")
                    @Expose
                    val frontTransparent: String? = null
                )
            }

            data class GenerationIi(
                @SerializedName("crystal")
                @Expose
                val crystal: Crystal? = null,
                @SerializedName("gold")
                @Expose
                val gold: Gold? = null,
                @SerializedName("silver")
                @Expose
                val silver: Silver? = null
            ) {
                data class Crystal(
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_shiny")
                    @Expose
                    val backShiny: String? = null,
                    @SerializedName("back_shiny_transparent")
                    @Expose
                    val backShinyTransparent: String? = null,
                    @SerializedName("back_transparent")
                    @Expose
                    val backTransparent: String? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_transparent")
                    @Expose
                    val frontShinyTransparent: String? = null,
                    @SerializedName("front_transparent")
                    @Expose
                    val frontTransparent: String? = null
                )

                data class Gold(
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_shiny")
                    @Expose
                    val backShiny: String? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null,
                    @SerializedName("front_transparent")
                    @Expose
                    val frontTransparent: String? = null
                )

                data class Silver(
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_shiny")
                    @Expose
                    val backShiny: String? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null,
                    @SerializedName("front_transparent")
                    @Expose
                    val frontTransparent: String? = null
                )
            }

            data class GenerationIii(
                @SerializedName("emerald")
                @Expose
                val emerald: Emerald? = null,
                @SerializedName("firered-leafgreen")
                @Expose
                val fireredLeafgreen: FireredLeafgreen? = null,
                @SerializedName("ruby-sapphire")
                @Expose
                val rubySapphire: RubySapphire? = null
            ) {
                data class Emerald(
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null
                )

                data class FireredLeafgreen(
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_shiny")
                    @Expose
                    val backShiny: String? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null
                )

                data class RubySapphire(
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_shiny")
                    @Expose
                    val backShiny: String? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null
                )
            }

            data class GenerationIv(
                @SerializedName("diamond-pearl")
                @Expose
                val diamondPearl: DiamondPearl? = null,
                @SerializedName("heartgold-soulsilver")
                @Expose
                val heartgoldSoulsilver: HeartgoldSoulsilver? = null,
                @SerializedName("platinum")
                @Expose
                val platinum: Platinum? = null
            ) {
                data class DiamondPearl(
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_female")
                    @Expose
                    val backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    @Expose
                    val backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    @Expose
                    val backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    @Expose
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    @Expose
                    val frontShinyFemale: Any? = null
                )

                data class HeartgoldSoulsilver(
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_female")
                    @Expose
                    val backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    @Expose
                    val backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    @Expose
                    val backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    @Expose
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    @Expose
                    val frontShinyFemale: Any? = null
                )

                data class Platinum(
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_female")
                    @Expose
                    val backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    @Expose
                    val backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    @Expose
                    val backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    @Expose
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    @Expose
                    val frontShinyFemale: Any? = null
                )
            }

            data class GenerationV(
                @SerializedName("black-white")
                @Expose
                val blackWhite: BlackWhite? = null
            ) {
                data class BlackWhite(
                    @SerializedName("animated")
                    @Expose
                    val animated: Animated? = null,
                    @SerializedName("back_default")
                    @Expose
                    val backDefault: String? = null,
                    @SerializedName("back_female")
                    @Expose
                    val backFemale: Any? = null,
                    @SerializedName("back_shiny")
                    @Expose
                    val backShiny: String? = null,
                    @SerializedName("back_shiny_female")
                    @Expose
                    val backShinyFemale: Any? = null,
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    @Expose
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    @Expose
                    val frontShinyFemale: Any? = null
                ) {
                    data class Animated(
                        @SerializedName("back_default")
                        @Expose
                        val backDefault: String? = null,
                        @SerializedName("back_female")
                        @Expose
                        val backFemale: Any? = null,
                        @SerializedName("back_shiny")
                        @Expose
                        val backShiny: String? = null,
                        @SerializedName("back_shiny_female")
                        @Expose
                        val backShinyFemale: Any? = null,
                        @SerializedName("front_default")
                        @Expose
                        val frontDefault: String? = null,
                        @SerializedName("front_female")
                        @Expose
                        val frontFemale: Any? = null,
                        @SerializedName("front_shiny")
                        @Expose
                        val frontShiny: String? = null,
                        @SerializedName("front_shiny_female")
                        @Expose
                        val frontShinyFemale: Any? = null
                    )
                }
            }

            data class GenerationVi(
                @SerializedName("omegaruby-alphasapphire")
                @Expose
                val omegarubyAlphasapphire: OmegarubyAlphasapphire? = null,
                @SerializedName("x-y")
                @Expose
                val xY: XY? = null
            ) {
                data class OmegarubyAlphasapphire(
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    @Expose
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    @Expose
                    val frontShinyFemale: Any? = null
                )

                data class XY(
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    @Expose
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    @Expose
                    val frontShinyFemale: Any? = null
                )
            }

            data class GenerationVii(
                @SerializedName("icons")
                @Expose
                val icons: Icons? = null,
                @SerializedName("ultra-sun-ultra-moon")
                @Expose
                val ultraSunUltraMoon: UltraSunUltraMoon? = null
            ) {
                data class Icons(
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    @Expose
                    val frontFemale: Any? = null
                )

                data class UltraSunUltraMoon(
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    @Expose
                    val frontFemale: Any? = null,
                    @SerializedName("front_shiny")
                    @Expose
                    val frontShiny: String? = null,
                    @SerializedName("front_shiny_female")
                    @Expose
                    val frontShinyFemale: Any? = null
                )
            }

            data class GenerationViii(
                @SerializedName("icons")
                @Expose
                val icons: Icons? = null
            ) {
                data class Icons(
                    @SerializedName("front_default")
                    @Expose
                    val frontDefault: String? = null,
                    @SerializedName("front_female")
                    @Expose
                    val frontFemale: Any? = null
                )
            }
        }
    }

    data class Stat(
        @SerializedName("base_stat")
        @Expose
        val baseStat: Int? = null,
        @SerializedName("effort")
        @Expose
        val effort: Int? = null,
        @SerializedName("stat")
        @Expose
        val stat: Stat? = null
    ) {
        data class Stat(
            @SerializedName("name")
            @Expose
            val name: String? = null,
            @SerializedName("url")
            @Expose
            val url: String? = null
        )
    }

    data class Type(
        @SerializedName("slot")
        @Expose
        val slot: Int? = null,
        @SerializedName("type")
        @Expose
        val type: Type? = null
    ) {
        data class Type(
            @SerializedName("name")
            @Expose
            val name: String? = null,
            @SerializedName("url")
            @Expose
            val url: String? = null
        )
    }
}