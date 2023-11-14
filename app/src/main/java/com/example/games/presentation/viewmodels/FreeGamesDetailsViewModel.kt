package com.example.games.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class FreeGamesDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private val gameId : String = checkNotNull(savedStateHandle["id"])


}