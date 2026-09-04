import androidx.lifecycle.ViewModel
import com.example.movieapp.data.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Collections.emptyList


class MovieViewModel: ViewModel() {
    private val repository = MovieViewModel()
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())

    val movie: StateFlow<List<Movie>> = _movies.asStateFlow()

    init{
        loadMovies()
    }

    private fun loadMovies()
    {
        _movies.value = repository.getMovies()
        }

}