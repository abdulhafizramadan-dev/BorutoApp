package com.ahr.borutoapp.presentation.screen.welcome

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ahr.borutoapp.R
import com.ahr.borutoapp.domain.model.OnBoarding
import com.ahr.borutoapp.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahr.borutoapp.navigation.Screen

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    welcomeViewModel: WelcomeViewModel = hiltViewModel(),
) {
    val onBoardingScreens = listOf(
        OnBoarding.Greetings,
        OnBoarding.Explore,
        OnBoarding.Power,
    )

    val pagerState = rememberPagerState()
    val finishButtonVisibility by remember(pagerState.currentPage) {
        derivedStateOf { pagerState.currentPage == onBoardingScreens.size-1 }
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            count = onBoardingScreens.size,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.weight(10f)
        ) { page ->
            WelcomeScreenItem(onBoarding = onBoardingScreens[page])
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.horizontalActiveIndicatorColor,
            inactiveColor = MaterialTheme.colors.horizontalInactiveIndicatorColor,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)
        )
        WelcomeScreenFinishButton(
            isVisible = finishButtonVisibility,
            onButtonClicked = {
                welcomeViewModel.saveOnBoardingState(true)
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            },
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun WelcomeScreenItem(
    onBoarding: OnBoarding,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = onBoarding.photo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f)
        )
        Text(
            text = stringResource(id = onBoarding.title),
            style = MaterialTheme.typography.titleOnBoarding,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(id = onBoarding.description),
            style = MaterialTheme.typography.descriptionOnBoarding,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SMALL_PADDING)
                .padding(horizontal = EXTRA_LARGE_PADDING)
        )
    }
}

@Composable
fun WelcomeScreenFinishButton(
    isVisible: Boolean,
    onButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.padding(horizontal = LARGE_PADDING)) {
        AnimatedVisibility(
            visible = isVisible,
            modifier = Modifier.fillMaxWidth(),
            enter = slideInVertically() + fadeIn(),
            exit = slideOutVertically() + fadeOut()
        ) {
            Button(onClick = onButtonClicked) {
                Text(text = stringResource(R.string.finish))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    BorutoAppTheme {
        WelcomeScreen(navController = rememberNavController())
    }
}
