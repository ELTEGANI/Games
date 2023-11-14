package com.example.games.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.games.core.common.Resource
import com.example.games.domain.usecases.FreeGamesUseCases
import com.example.games.presentation.state.FreeGameState
import com.example.games.presentation.state.UiEffect
import com.example.games.presentation.state.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class FreeGamesViewModel @Inject constructor(private val freeGamesUseCases: FreeGamesUseCases):ViewModel() {
    private val _freeGamesState = MutableStateFlow(FreeGameState())
    val freeGamesState:StateFlow<FreeGameState>
    get() = _freeGamesState

    private val _uiEffect = MutableSharedFlow<UiEffect>()
    val uiEffect: SharedFlow<UiEffect>
        get() = _uiEffect.asSharedFlow()


    init {
        getAllFreeGames()
    }
    private fun getAllFreeGames() = freeGamesUseCases().onEach{
          when(it){
              is Resource.Error->{
                   _freeGamesState.value = FreeGameState().copy(
                       errorMsg = it.msg
                   )
                  _uiEffect.emit(UiEffect.ShowSnackBar(it.msg.toString()))
              }
              is Resource.Loading->{
                  _freeGamesState.value = FreeGameState().copy(
                      isLoading =true
                  )
              }
              is Resource.Success->{
                  _freeGamesState.value = FreeGameState().copy(
                      freeGames = it.data
                  )
              }
          }
    }.launchIn(viewModelScope)

    
}