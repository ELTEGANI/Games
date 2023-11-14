package com.example.games.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.games.core.common.Resource
import com.example.games.domain.usecases.FreeGamesDetailsUseCases
import com.example.games.presentation.state.FreeGameDetailState
import com.example.games.presentation.state.FreeGameState
import com.example.games.presentation.state.UiEffect
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
class FreeGamesDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val freeGamesDetailsUseCases : FreeGamesDetailsUseCases
):ViewModel() {
    private val _freeGamesDetailsState = MutableStateFlow(FreeGameDetailState())
    val freeGamesDetailsState: StateFlow<FreeGameDetailState>
        get() = _freeGamesDetailsState

    private val _uiEffect = MutableSharedFlow<UiEffect>()
    val uiEffect: SharedFlow<UiEffect>
        get() = _uiEffect.asSharedFlow()

    private val gameId : String = checkNotNull(savedStateHandle["id"])

    init {
        getFreeGameDetailsById(gameId)

    }
    private fun getFreeGameDetailsById(gameDetailId:String) = freeGamesDetailsUseCases(gameDetailId).onEach{
        when(it){
            is Resource.Error->{
                _freeGamesDetailsState.value = FreeGameDetailState().copy(
                    errorMsg = it.msg
                )
                _uiEffect.emit(UiEffect.ShowSnackBar(it.msg.toString()))
            }
            is Resource.Loading->{
                _freeGamesDetailsState.value = FreeGameDetailState().copy(
                    isLoading =true
                )
            }
            is Resource.Success->{
                _freeGamesDetailsState.value = FreeGameDetailState().copy(
                    freeGamesDetail =  it.data
                )
            }
        }
    }.launchIn(viewModelScope)

}