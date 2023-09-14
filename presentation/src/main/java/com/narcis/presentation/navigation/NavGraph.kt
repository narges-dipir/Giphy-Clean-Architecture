package com.narcis.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.narcis.presentation.screen.HomeScreen
import com.narcis.presentation.screen.SingleSearchResultGifScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Navigation.Home.route) {
        composable(route = Navigation.Home.route) {
            HomeScreen(navController)
        }
        composable(route = Navigation.SingleGif.route + "/{url}" + "/{title}" + "/{rating}") {
            SingleSearchResultGifScreen(navController = navController)
        }
    }
}
