package com.andriawan24.mysudoku.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andriawan24.mysudoku.ui.theme.MySudokuTheme

@Composable
fun SudokuBoardItem(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    textSize: TextUnit = 22.sp,
    isDefault: Boolean = false,
    onItemClicked: () -> Unit,
    isEdited: Boolean = false,
    boxSize: Dp = 48.dp
) {
    Box(
        modifier = modifier
            .size(boxSize)
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            .border(
                width = 1.dp,
                color = if (!isEdited) Color(0xFFCFCFCF) else MaterialTheme.colorScheme.primary
            )
            .clickable { onItemClicked() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium.copy(
                color = if (isDefault) MaterialTheme.colorScheme.primary else textColor,
                fontSize = textSize
            )
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun GameContentPreview() {
    MySudokuTheme {
        SudokuBoardItem(
            text = "20",
            isDefault = false,
            onItemClicked = {}
        )
    }
}