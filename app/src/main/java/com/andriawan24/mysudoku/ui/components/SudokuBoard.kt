package com.andriawan24.mysudoku.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.andriawan24.mysudoku.ui.theme.MySudokuTheme

@Composable
fun SudokuBoard() {
    Column {
        Row(horizontalArrangement = Arrangement.Center) {
            SudokuBoardItem(text = "1", isDefault = true)
            SudokuBoardItem(text = "")
            SudokuBoardItem(text = "")
        }
        Row(horizontalArrangement = Arrangement.Center) {
            SudokuBoardItem(text = "1", isDefault = true)
            SudokuBoardItem(text = "")
            SudokuBoardItem(text = "")
        }
        Row(horizontalArrangement = Arrangement.Center) {
            SudokuBoardItem(text = "1", isDefault = true)
            SudokuBoardItem(text = "")
            SudokuBoardItem(text = "")
        }
    }
}

@Preview
@Composable
fun SudokuBoardPreview() {
    MySudokuTheme {
        SudokuBoard()
    }
}