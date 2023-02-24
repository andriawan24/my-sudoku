package com.andriawan24.mysudoku.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.andriawan24.mysudoku.ui.presenter.game.GameScreen
import com.andriawan24.mysudoku.ui.presenter.home.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.routeName
    ) {
        homeRoute(
            navigateToGame = {
                navController.navigate(Screen.Game.routeName)
            }
        )
        gameRoute(
            onBackButtonClicked = {
                navController.popBackStack()
            }
        )
    }
}

fun NavGraphBuilder.homeRoute(
    navigateToGame: () -> Unit
) {
    composable(Screen.Home.routeName) {
        HomeScreen(navigateToGame = navigateToGame)
    }
}

fun NavGraphBuilder.gameRoute(onBackButtonClicked: () -> Unit) {
    composable(Screen.Game.routeName) {
        GameScreen(onBackButtonClicked = onBackButtonClicked)
    }
}