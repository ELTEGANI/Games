package com.example.games.presentation.state

sealed class UiEffect {
class ShowSnackBar(val msg:String):UiEffect()
object NavigateToDetailScreen:UiEffect()
}