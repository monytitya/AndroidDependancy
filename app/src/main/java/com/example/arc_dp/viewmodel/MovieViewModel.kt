package com.example.arc_dp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.arc_dp.data.Movie
import com.example.arc_dp.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MovieViewModel : ViewModel() {
    private val repository = MovieRepository()
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())

    val movies: StateFlow<List<Movie>> = _movies.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        _movies.value = repository.getMovies()
    }
}
