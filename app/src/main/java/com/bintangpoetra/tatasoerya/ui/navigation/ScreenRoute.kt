package com.bintangpoetra.tatasoerya.ui.navigation

sealed class ScreenRoute(val route: String) {
    object Splash: ScreenRoute("splash")
    object Home: ScreenRoute("home")
    object Explore: ScreenRoute("explore")
    object Profile: ScreenRoute("profile")
}