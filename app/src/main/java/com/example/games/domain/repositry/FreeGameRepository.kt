package com.example.games.domain.repositry

import com.example.games.core.common.Resource
import com.example.games.domain.model.FreeGameDetail
import com.example.games.domain.model.FreeGames
import kotlinx.coroutines.flow.Flow

interface FreeGameRepository {
    fun getFreeGames(): Flow<Resource<List<FreeGames>>>
    fun getFreeGamesDetails(id:String): Flow<Resource<FreeGameDetail>>
}