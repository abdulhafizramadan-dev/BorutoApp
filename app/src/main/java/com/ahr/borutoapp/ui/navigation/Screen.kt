package com.ahr.borutoapp.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Welcome : Screen("welcome_screen")
    object Home : Screen("home_screen")
    object Search : Screen("search_screen")

    object Detail : Screen("detail_screen/{hero_id}") {
        fun passHeroId(heroId: Int): String {
            return "detail_screen/$heroId"
        }

        const val HERO_ID = "hero_id"
    }
}
