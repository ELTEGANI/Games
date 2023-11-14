package com.example.games.domain.usecases

import com.example.games.domain.repositry.FreeGameRepository
import javax.inject.Inject

class FreeGamesDetailsUseCases @Inject constructor(private val freeGameRepository: FreeGameRepository) {
    operator fun invoke(id:String) = freeGameRepository.getFreeGamesDetails(id)

}