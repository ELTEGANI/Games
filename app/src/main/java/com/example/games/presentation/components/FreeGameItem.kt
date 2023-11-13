package com.example.games.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.games.domain.model.FreeGames


@Composable
fun FreeGameItem(modifier: Modifier,freeGames: FreeGames){
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
        Card (
            elevation = CardDefaults.cardElevation(4.dp), shape = RoundedCornerShape(16.dp)
        ){
         Column(modifier= Modifier
             .padding(8.dp)
             .fillMaxWidth(), horizontalAlignment =
         Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
          AsyncImage(model = freeGames.thumbnail, contentDescription = "",
              modifier = Modifier
                  .padding(4.dp)
                  .fillMaxWidth(), contentScale = ContentScale.Crop)
         }
            Text(text = freeGames.title?:"", fontWeight = FontWeight.Bold)
            Text(text = freeGames.shortDescription?:"", fontWeight = FontWeight.Bold)
        }
    }
}