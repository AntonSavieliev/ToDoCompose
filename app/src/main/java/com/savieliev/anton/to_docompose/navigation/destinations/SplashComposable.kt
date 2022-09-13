package com.savieliev.anton.to_docompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.savieliev.anton.to_docompose.ui.screens.splash.SplashScreen
import com.savieliev.anton.to_docompose.util.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
) {
    composable(route = SPLASH_SCREEN) {
        SplashScreen(navigateToTaskScreen = navigateToListScreen)
    }
}
