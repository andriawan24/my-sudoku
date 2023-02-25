package com.andriawan24.mysudoku.ui.presenter.game

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andriawan24.mysudoku.models.getRandomSudokuModel
import com.andriawan24.mysudoku.ui.components.SudokuBoard
import com.andriawan24.mysudoku.ui.theme.MySudokuTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    onBackButtonClicked: () -> Unit
) {
    Scaffold(
        topBar = { GameTopBar(onBackButtonClicked) }
    ) {
        GameContent(
            modifier = Modifier.fillMaxSize(),
            paddingValues = it
        )
    }
}

@Composable
fun GameContent(modifier: Modifier = Modifier, paddingValues: PaddingValues) {
    Column(
        modifier = modifier.padding(paddingValues)
    ) {
        val sudokuModel = remember {
            mutableStateListOf(
                listOf(
                    getRandomSudokuModel(),
                    getRandomSudokuModel(),
                    getRandomSudokuModel()
                ),
                listOf(
                    getRandomSudokuModel(),
                    getRandomSudokuModel(),
                    getRandomSudokuModel()
                ),
                listOf(
                    getRandomSudokuModel(),
                    getRandomSudokuModel(),
                    getRandomSudokuModel()
                ),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 14.dp)
        ) {
            sudokuModel.forEach { sudoku ->
                BoxWithConstraints {
                    val width = maxWidth / 9
                    Row(modifier = Modifier.fillMaxWidth()) {
                        sudoku.forEach {
                            Box(modifier = Modifier.border(width = 2.dp, color = Color.White)) {
                                SudokuBoard(
                                    sudokuModel = it,
                                    onItemClicked = { },
                                    boxSize = width
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameTopBar(onBackButtonClicked: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "My Sudoku",
                style = MaterialTheme.typography.titleMedium,
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackButtonClicked) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Button"
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, device = Devices.TABLET)
@Composable
fun GameContentPreview() {
    MySudokuTheme {
        GameContent(paddingValues = PaddingValues(0.dp))
    }
}
