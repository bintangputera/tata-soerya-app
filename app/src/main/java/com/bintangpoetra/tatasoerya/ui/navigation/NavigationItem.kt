package com.bintangpoetra.tatasoerya.ui.navigation

import androidx.annotation.DrawableRes

data class NavigationItem(
    val title: String,
    @DrawableRes val icon: Int,
    val screen: ScreenRoute
)