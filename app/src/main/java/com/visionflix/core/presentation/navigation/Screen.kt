package com.visionflix.core.presentation.navigation

sealed class MainScreens(val route: String) {
    data object Home : MainScreens("homepage_screen")
}

