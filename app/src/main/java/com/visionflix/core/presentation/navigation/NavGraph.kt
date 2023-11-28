package com.visionflix.core.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.visionflix.core.presentation.ui.screen.home.HomeScreen
import com.visionflix.core.presentation.viewmodel.HomeScreenViewModel
import org.koin.androidx.compose.getViewModel

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable(route = MainScreens.Home.route) {
        val viewModel = getViewModel<HomeScreenViewModel>()

        HomeScreen(viewModel = viewModel) {

        }
    }
}