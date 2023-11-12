package com.example.games.data

import com.example.games.data.remote.dto.FreeGamesDto
import retrofit2.http.GET

interface FreeGamesApi {
  @GET("games")
  suspend fun getFreeGame():List<FreeGamesDto>
}