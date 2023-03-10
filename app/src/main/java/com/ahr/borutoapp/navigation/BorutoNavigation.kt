package com.ahr.borutoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ahr.borutoapp.presentation.screen.home.HomeScreen
import com.ahr.borutoapp.presentation.screen.splash.SplashScreen
import com.ahr.borutoapp.presentation.screen.welcome.WelcomeScreen

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
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
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