package com.savieliev.anton.to_docompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.savieliev.anton.to_docompose.ui.screens.splash.SplashScreen
import com.savieliev.anton.to_docompose.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
) {
    composable(
        route = SPLASH_SCREEN,
        exitTransition = { _, _ ->
            slideOutVertically(
                targetOffsetY = { -it },
                animationSpec = tween(300)
            )
        }
    ) {
        SplashScreen(navigateToTaskScreen = navigateToListScreen)
    }
}
