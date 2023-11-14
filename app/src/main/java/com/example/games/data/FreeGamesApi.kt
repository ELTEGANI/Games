package com.example.games.data

import com.example.games.data.remote.dto.FreeGamesDetailsDto
import com.example.games.data.remote.dto.FreeGamesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FreeGamesApi {
  @GET("games")
  suspend fun getFreeGame():List<FreeGamesDto>

  @GET("game")
  suspend fun getGameById(@Query("id") id:String):FreeGamesDetailsDto
}