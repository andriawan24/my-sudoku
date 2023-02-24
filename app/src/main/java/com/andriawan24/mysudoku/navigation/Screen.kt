package com.andriawan24.mysudoku.navigation

sealed class Screen(val routeName: String) {
    object Home : Screen("home_screen")
    object Game : Screen("game_screen")
}