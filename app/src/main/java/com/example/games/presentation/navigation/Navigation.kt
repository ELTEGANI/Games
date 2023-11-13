package com.example.games.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.games.presentation.components.GameScreen
import com.example.games.presentation.navigation.screens.Screen
import com.example.games.presentation.viewmodels.FreeGamesViewModel


@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.GameScreen.route){
        composable(Screen.GameScreen.route){
            val freeGameViewModel = hiltViewModel<FreeGamesViewModel>()
            val freeGamesState = freeGameViewModel.freeGamesState.collectAsStateWithLifecycle()
            GameScreen(freeGameState = freeGamesState.value, modifier = Modifier)
        }
    }
}