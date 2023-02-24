package com.andriawan24.mysudoku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.andriawan24.mysudoku.navigation.AppNavGraph
import com.andriawan24.mysudoku.ui.presenter.home.HomeScreen
import com.andriawan24.mysudoku.ui.theme.MySudokuTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MySudokuTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}