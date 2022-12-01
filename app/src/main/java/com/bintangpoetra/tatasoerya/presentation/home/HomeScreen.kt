package com.bintangpoetra.tatasoerya.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bintangpoetra.tatasoerya.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                title = {
                    Row {
                        Image(
                            modifier = modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.ic_logo),
                            contentDescription = stringResource(id = R.string.logo)
                        )
                        Text(
                            modifier = modifier.padding(start = 8.dp),
                            text = stringResource(id = R.string.app_name),
                            style = MaterialTheme.typography.h1.copy(color = Color.White),
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.
                    padding(
                        horizontal = 16.dp, vertical = 12.dp)
        ) {
            HeaderTitle()
        }
    }
}

@Composable
fun HeaderTitle() {
    val annotatedString = buildAnnotatedString {
        withStyle(style = headerSpanStyle.copy(fontWeight = FontWeight.Normal)) {
            append(stringResource(R.string.label_explore_our))
        }
        withStyle(style = headerSpanStyle.copy(fontWeight = FontWeight.Bold)) {
            append(stringResource(R.string.label_solar_system))
        }
    }
    Text(
        text = annotatedString
    )
}

val headerSpanStyle: SpanStyle = SpanStyle(color = Color.White, fontSize = 32.sp)