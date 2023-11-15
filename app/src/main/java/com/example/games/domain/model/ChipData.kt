package com.example.games.domain.model

data class ChipData(val label: String, var isSelected: Boolean = false)


val chipDataList = listOf(
    ChipData("3d"),
    ChipData("2d"),
    ChipData("action"),
    ChipData("tower-defense"),
    ChipData("strategy"),
    ChipData("racing"),
    ChipData("sports"),
    ChipData("social"),
    ChipData("sandbox"),
    ChipData(" battle-royale")
)