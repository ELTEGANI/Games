package com.example.games.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.games.presentation.state.FreeGameDetailState
import com.example.games.presentation.state.FreeGameState

@Composable
fun FreeGameDetailScreen(
    freeGameState : FreeGameDetailState,
    modifier: Modifier,
) {
    Text(text = "title:${freeGameState.freeGamesDetail?.title?:""}")
}