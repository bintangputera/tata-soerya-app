package com.bintangpoetra.tatasoerya.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bintangpoetra.tatasoerya.R

// Set of Material typography styles to start with

val fonts = FontFamily(
    Font(R.font.nunito_black, weight = FontWeight.Black),
    Font(R.font.nunito_bold, weight = FontWeight.Bold),
    Font(R.font.nunito_regular, weight = FontWeight.Normal)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
)