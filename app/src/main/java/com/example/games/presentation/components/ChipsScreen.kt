package com.example.games.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.games.domain.model.ChipData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipsScreen(chipDataList: List<ChipData>) {
    LazyRow {
        items(chipDataList) { chipData ->
            var selected by remember { mutableStateOf(chipData.isSelected) }
            Column(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth()
            ) {
                FilterChip(
                    onClick = { selected = !selected },
                    label = {
                        Text(chipData.label)
                    },
                    selected = selected,
                    leadingIcon = if (selected) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}