package com.example.arc_dp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.example.arc_dp.ui.MovieScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MovieScreen()
                }
            }
        }
    }
}

@Composable
fun MovieAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}
