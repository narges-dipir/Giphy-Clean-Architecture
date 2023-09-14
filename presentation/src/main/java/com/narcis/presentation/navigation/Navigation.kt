package com.narcis.presentation.navigation

sealed class Navigation(val route: String) {
    object Home : Navigation("random_gif_screen")
    object SingleGif : Navigation("single_gif_screen")
}
