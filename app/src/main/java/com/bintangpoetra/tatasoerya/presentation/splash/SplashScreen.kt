package com.bintangpoetra.tatasoerya.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.bintangpoetra.tatasoerya.R
import com.bintangpoetra.tatasoerya.ui.navigation.ScreenRoute
import com.bintangpoetra.tatasoerya.utils.ConstVal
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    LaunchedEffect(key1 = true) {
        delay(ConstVal.SPLASH_DELAY_TIME)
        navController.navigate(ScreenRoute.Home.route)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(
                    id = R.string.logo
                )
            )
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h1.copy(color = Color.White)
            )
        }
    }
}