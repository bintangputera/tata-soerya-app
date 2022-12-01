package com.bintangpoetra.tatasoerya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bintangpoetra.tatasoerya.presentation.explore.ExploreScreen
import com.bintangpoetra.tatasoerya.presentation.home.HomeScreen
import com.bintangpoetra.tatasoerya.presentation.profile.ProfileScreen
import com.bintangpoetra.tatasoerya.presentation.splash.SplashScreen
import com.bintangpoetra.tatasoerya.ui.components.BottomNavBar
import com.bintangpoetra.tatasoerya.ui.navigation.ScreenRoute
import com.bintangpoetra.tatasoerya.ui.theme.TataSoeryaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TataSoeryaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != ScreenRoute.Splash.route) {
                BottomNavBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenRoute.Splash.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenRoute.Splash.route) {
                SplashScreen(navController = navController)
            }
            composable(ScreenRoute.Home.route) {
                HomeScreen()
            }
            composable(ScreenRoute.Explore.route) {
                ExploreScreen()
            }
            composable(ScreenRoute.Profile.route) {
                ProfileScreen()
            }
        }
    }
}