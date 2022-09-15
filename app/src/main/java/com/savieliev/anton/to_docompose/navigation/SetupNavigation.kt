package com.savieliev.anton.to_docompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.savieliev.anton.to_docompose.navigation.destinations.listComposable
import com.savieliev.anton.to_docompose.navigation.destinations.splashComposable
import com.savieliev.anton.to_docompose.navigation.destinations.taskComposable
import com.savieliev.anton.to_docompose.ui.viewmodels.SharedViewModel
import com.savieliev.anton.to_docompose.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    AnimatedNavHost(navController = navController, startDestination = SPLASH_SCREEN) {
        splashComposable(
            navigateToListScreen = screen.splash
        )
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
    }
}
