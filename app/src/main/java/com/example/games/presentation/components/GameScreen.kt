package com.example.games.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.games.domain.model.chipDataList
import com.example.games.presentation.navigation.screens.Screen
import com.example.games.presentation.state.FreeGameState


@Composable
fun GameScreen(freeGameState: FreeGameState, modifier: Modifier, navController: NavHostController){
    Column {
        ChipsScreen(chipDataList)
        Spacer(modifier = Modifier.height(5.dp))
        if (freeGameState.freeGames?.isNotEmpty()!!) {
            LazyColumn {
                items(freeGameState.freeGames) { freeGamesList ->
                    FreeGameItem(modifier, freeGames = freeGamesList, onItemClicked = {
                        navController.navigate(Screen.GameDetialsScreen.route + "/${freeGamesList.id}")
                    })
                }
            }
        } else if (freeGameState.isLoading) {
            Box(modifier = modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
            }
        }
    }
}