package com.ahr.borutoapp.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    MaterialTheme.colors
    Scaffold(
        topBar = {

        },
        modifier = modifier
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
    }
}