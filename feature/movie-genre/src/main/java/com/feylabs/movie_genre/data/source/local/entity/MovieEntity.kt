package com.feylabs.movie_genre.data.source.local.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "movie_items")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val adult: Boolean = false,
    val backdropPath: String = "",
    val genreIds: Int = 0,
    val originalLanguage: String = "",
    val originalTitle: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val posterPath: String = "",
    val releaseDate: String = "",
    val title: String = "",
    val video: Boolean = false,
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0
)
