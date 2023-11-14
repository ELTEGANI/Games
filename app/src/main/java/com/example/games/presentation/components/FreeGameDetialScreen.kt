package com.example.games.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.games.presentation.viewmodels.FreeGamesDetailsViewModel

@Composable
fun FreeGameDetailScreen(
    freeGamesDetailsViewModel: FreeGamesDetailsViewModel = hiltViewModel()
) {
    Text(text = "games")
}