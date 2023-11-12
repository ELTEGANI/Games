package com.example.games.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.games.domain.usecases.FreeGamesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FreeGamesViewModel @Inject constructor(private val freeGamesUseCases: FreeGamesUseCases):ViewModel() {
}