package com.example.games.presentation.navigation.screens

sealed class Screen(val route:String) {
  object GameScreen:Screen("game_screen")
}