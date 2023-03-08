package com.ahr.borutoapp.presentation.screen.splash

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ahr.borutoapp.R
import com.ahr.borutoapp.navigation.Screen
import com.ahr.borutoapp.ui.theme.BorutoAppTheme
import com.ahr.borutoapp.ui.theme.Purple500
import com.ahr.borutoapp.ui.theme.Purple700

@Composable
fun SplashScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    splashScreenViewModel: SplashScreenViewModel = hiltViewModel(),
) {
    val degrees = remember {
        Animatable(0f)
    }
    val onBoardingCompleted by splashScreenViewModel.readOnBoardingState.collectAsState()
    LaunchedEffect(key1 = Unit) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
        navController.popBackStack()
        if (onBoardingCompleted) {
            navController.navigate(Screen.Home.route)
        } else {
            navController.navigate(Screen.Welcome.route)
        }
    }
    Splash(degrees = degrees.value, modifier = modifier)
}

@Composable
fun Splash(
    degrees: Float,
    modifier: Modifier = Modifier,
) {

    val splashScreenModifier = if (isSystemInDarkTheme()) {
        modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
    } else {
        modifier
            .background(Brush.verticalGradient(colors = listOf(Purple500, Purple700, Purple500)))
            .fillMaxSize()
    }

    Box(
        modifier = splashScreenModifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.app_logo),
            modifier = Modifier.rotate(degrees = degrees)
        )
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewSplashScreen() {
    BorutoAppTheme {
        SplashScreen(navController = rememberNavController())
    }
}
