package com.ahr.borutoapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ahr.borutoapp.presentation.screen.splash.SplashScreen

@Composable
fun BorutoNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {

        }
        composable(route = Screen.Home.route) {

        }
        composable(route = Screen.Search.route) {

        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(Screen.Detail.HERO_ID) { type = NavType.IntType }
            )
        ) {
        }
    }
}