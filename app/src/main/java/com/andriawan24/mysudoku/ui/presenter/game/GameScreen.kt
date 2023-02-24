package com.andriawan24.mysudoku.ui.presenter.game

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andriawan24.mysudoku.ui.components.SudokuBoardItem
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
        modifier = modifier
            .padding(paddingValues)
    ) {
        SudokuBoardItem(text = "2")
    }
}

@Preview
@Composable
fun GameContentPreview() {
    MySudokuTheme {
        GameContent(paddingValues = PaddingValues(0.dp))
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
