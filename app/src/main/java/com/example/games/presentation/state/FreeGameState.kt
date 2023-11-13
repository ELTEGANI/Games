package com.example.games.presentation.state

import com.example.games.domain.model.FreeGames

data class FreeGameState(
    val freeGames:List<FreeGames>? = emptyList(),
    val errorMsg:String? = "",
    val isLoading:Boolean = false
)