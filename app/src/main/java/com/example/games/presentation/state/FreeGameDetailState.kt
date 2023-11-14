package com.example.games.presentation.state

import com.example.games.domain.model.FreeGameDetail



data class FreeGameDetailState(
    val freeGamesDetail: FreeGameDetail? = null,
    val errorMsg:String? = "",
    val isLoading:Boolean = false
)