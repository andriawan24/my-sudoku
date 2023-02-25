package com.andriawan24.mysudoku.models

import kotlin.random.Random

data class SudokuModel(
    var number: Int? = null,
    var isEdited: Boolean = false,
    var isDefault: Boolean = false
)

fun getEmptySudokuModel(): List<List<SudokuModel>> {
    return listOf(
        listOf(SudokuModel(), SudokuModel(), SudokuModel()),
        listOf(SudokuModel(), SudokuModel(), SudokuModel()),
        listOf(SudokuModel(), SudokuModel(), SudokuModel())
    )
}

fun getRandomSudokuModel(): List<List<SudokuModel>> {
    val randomBoard: MutableList<List<SudokuModel>> = mutableListOf()
    val randomNumbers = (1 until 10).shuffled()
    var currentSliceIndex = 0
    for (i in 1..3) {
        val sublist = randomNumbers.subList(currentSliceIndex, currentSliceIndex + 3)
        currentSliceIndex += 3
        randomBoard.add(sublist.map { SudokuModel(number = null) })
    }

    val randomDefaultValueSize = (2..3).random()
    val defaultIndexes = mutableListOf<Int>()
    (1..randomDefaultValueSize).forEach { _ ->
        val randomIndex = randomNumbers.map { it - 1 }
            .filter { !defaultIndexes.contains(it) }
            .random()
        randomBoard.flatten()[randomIndex].isDefault = true
        randomBoard.flatten()[randomIndex].number = randomNumbers[randomIndex]
        defaultIndexes.add(randomIndex)
    }

    return randomBoard
}