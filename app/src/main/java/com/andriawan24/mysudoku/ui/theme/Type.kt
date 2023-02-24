package com.andriawan24.mysudoku.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.andriawan24.mysudoku.R

private val readExFontFamily = FontFamily(
    Font(R.font.readex_bold, weight = FontWeight.Bold),
    Font(R.font.readex_semibold, weight = FontWeight.SemiBold),
    Font(R.font.readex_medium, weight = FontWeight.Medium),
    Font(R.font.readex_regular, weight = FontWeight.Normal),
    Font(R.font.readex_light, weight = FontWeight.Light),
    Font(R.font.readex_extra_light, weight = FontWeight.ExtraLight)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 32.sp,
        fontFamily = readExFontFamily,
        fontWeight = FontWeight.Normal
    ),
    displayMedium = TextStyle(
        fontSize = 28.sp,
        fontFamily = readExFontFamily,
        fontWeight = FontWeight.Normal
    ),
    displaySmall = TextStyle(
        fontSize = 24.sp,
        fontFamily = readExFontFamily,
        fontWeight = FontWeight.Normal
    ),
    titleLarge = TextStyle(
        fontSize = 20.sp,
        fontFamily = readExFontFamily,
        fontWeight = FontWeight.Normal
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = readExFontFamily,
        fontWeight = FontWeight.Normal
    )
)