package com.bintangpoetra.tatasoerya.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bintangpoetra.tatasoerya.R
import com.bintangpoetra.tatasoerya.ui.navigation.NavigationItem
import com.bintangpoetra.tatasoerya.ui.navigation.ScreenRoute
import com.bintangpoetra.tatasoerya.ui.theme.Grey200


@Composable
fun BottomNavBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 32.dp)
    ) {
        BottomNavigation(
            backgroundColor = Grey200,
            contentColor = Grey200,
        ) {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            val navigationItems = listOf(
                NavigationItem(
                    icon = R.drawable.ic_home,
                    title = stringResource(id = R.string.menu_home),
                    screen = ScreenRoute.Home
                ),
                NavigationItem(
                    icon = R.drawable.ic_explore,
                    title = stringResource(id = R.string.menu_explore),
                    screen = ScreenRoute.Explore
                ),
                NavigationItem(
                    icon = R.drawable.ic_profile,
                    title = stringResource(id = R.string.menu_profile),
                    screen = ScreenRoute.Profile
                ),
            )
            BottomNavigation {
                navigationItems.map { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.title
                            )
                        },
                        selectedContentColor = Color(0XFFFFFF0E),
                        unselectedContentColor = Color.White,
                        label = { Text(text = item.title) },
                        selected = currentRoute == item.screen.route,
                        onClick = {
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                restoreState = true
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    }
}