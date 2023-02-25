package com.andriawan24.mysudoku.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.andriawan24.mysudoku.models.SudokuModel
import com.andriawan24.mysudoku.models.getRandomSudokuModel
import com.andriawan24.mysudoku.ui.theme.MySudokuTheme

@Composable
fun SudokuBoard(
    sudokuModel: List<List<SudokuModel>>,
    onItemClicked: (SudokuModel) -> Unit,
    boxSize: Dp = 48.dp
) {
    Column {
        sudokuModel.forEach {
            Row(horizontalArrangement = Arrangement.Center) {
                it.forEach { sudoku ->
                    SudokuBoardItem(
                        text = sudoku.number?.toString().orEmpty(),
                        isDefault = sudoku.isDefault,
                        isEdited = sudoku.isEdited,
                        onItemClicked = {
                            onItemClicked(sudoku)
                        },
                        boxSize = boxSize
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SudokuBoardPreview() {
    MySudokuTheme {
        SudokuBoard(
            sudokuModel = getRandomSudokuModel(),
            onItemClicked = {
                it.isEdited = true
            }
        )
    }
}