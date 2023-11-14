package com.example.games.data.remote.mapper

import com.example.games.data.remote.dto.FreeGamesDetailsDto
import com.example.games.data.remote.dto.FreeGamesDto
import com.example.games.domain.model.FreeGameDetail
import com.example.games.domain.model.FreeGames

fun FreeGamesDto.toDomainFreeGames():FreeGames {
    return FreeGames(gameUrl,id,shortDescription,thumbnail,title)
}


fun FreeGamesDetailsDto.toDomainFreeGamesDetails():FreeGameDetail {
    return FreeGameDetail(description,shortDescription,thumbnail,title)
}