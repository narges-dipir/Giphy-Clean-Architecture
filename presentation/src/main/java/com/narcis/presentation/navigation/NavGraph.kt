package com.narcis.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Navigation.Home.route) {
        composable(route = Navigation.Home.route) {
        }
        composable(route = Navigation.SingleGif.route + "/{url}" + "/{title}" + "/{rating}") {
        }
    }
}
