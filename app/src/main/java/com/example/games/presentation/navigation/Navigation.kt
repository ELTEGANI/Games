package com.example.games.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.games.presentation.components.FreeGameDetailScreen
import com.example.games.presentation.components.GameScreen
import com.example.games.presentation.navigation.screens.Screen
import com.example.games.presentation.state.UiEffect
import com.example.games.presentation.viewmodels.FreeGamesDetailsViewModel
import com.example.games.presentation.viewmodels.FreeGamesViewModel
import kotlinx.coroutines.flow.collectLatest


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(navController: NavHostController){
    val snackBarHostState = remember {
        SnackbarHostState()
    }
    Scaffold(snackbarHost = {SnackbarHost(hostState = snackBarHostState)}) { paddingValues ->
        NavHost(navController = navController, startDestination = Screen.GameScreen.route,
            modifier = Modifier.padding(paddingValues)){
            composable(Screen.GameScreen.route){
                val freeGameViewModel = hiltViewModel<FreeGamesViewModel>()
                val freeGamesState = freeGameViewModel.freeGamesState.collectAsStateWithLifecycle()
                GameScreen(freeGameState = freeGamesState.value, modifier = Modifier,navController)
                LaunchedEffect(key1 =true){
                    freeGameViewModel.uiEffect.collectLatest {
                        when(it){
                            is UiEffect.ShowSnackBar -> {
                                snackBarHostState.showSnackbar(it.msg)
                            }
                        }
                    }
                }
            }

            composable(Screen.GameDetialsScreen.route+"/{id}"){
                val freeGamesDetailsViewModel = hiltViewModel<FreeGamesDetailsViewModel>()
                val freeGamesDetailsState = freeGamesDetailsViewModel.freeGamesDetailsState.collectAsStateWithLifecycle()
                FreeGameDetailScreen(freeGameState = freeGamesDetailsState.value,modifier = Modifier)
                LaunchedEffect(key1 =true){
                    freeGamesDetailsViewModel.uiEffect.collectLatest {res->
                        when(res){
                            is UiEffect.ShowSnackBar -> {
                                snackBarHostState.showSnackbar(res.msg)
                            }
                        }
                    }
                }
            }
        }
    }
}