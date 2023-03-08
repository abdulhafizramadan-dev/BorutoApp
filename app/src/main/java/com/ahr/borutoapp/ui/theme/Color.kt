package com.ahr.borutoapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)

val Colors.titleOnBoardingColor
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.descriptionOnBoardingColor
    @Composable
    get() = if (isLight) DarkGray.copy(alpha = 0.5f)
    else LightGray.copy(alpha = 0.5f)

val Colors.horizontalActiveIndicatorColor
    @Composable
    get() = if (isLight) Purple500 else Purple700

val Colors.horizontalInactiveIndicatorColor
    @Composable
    get() = if (isLight) LightGray else DarkGray