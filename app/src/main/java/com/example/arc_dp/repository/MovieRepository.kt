package com.example.arc_dp.repository

import com.example.arc_dp.data.Movie

class MovieRepository {
    fun getMovies(): List<Movie> {
        return listOf(
            Movie(
                id = 1,
                title = "Legend the god",
                year = 2002,
                rating = 8.0
            ),
            Movie(
                id = 2,
                title = "Interstellar",
                year = 2014,
                rating = 8.7
            ),
            Movie(
                id = 3,
                title = "Inception",
                year = 2010,
                rating = 8.8
            ),
            Movie(
                id = 4,
                title = "The Dark Knight",
                year = 2008,
                rating = 9.0
            )
        )
    }
}
