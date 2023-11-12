package com.example.games.domain.usecases

import com.example.games.domain.repositry.FreeGameRepository
import javax.inject.Inject

class FreeGamesUseCases @Inject constructor(private val freeGameRepository: FreeGameRepository) {
    operator fun invoke() = freeGameRepository.getFreeGames()
}