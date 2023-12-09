package com.narcis.presentation.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import com.narcis.presentation.navigation.Navigation
import com.narcis.presentation.theme.GiphyTestTheme
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenKtTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        hiltRule.inject()
        composeTestRule.setContent {
            val navController = rememberNavController()
            GiphyTestTheme {
                NavHost(
                    navController = navController,
                    startDestination = Navigation.Home.route,
                ) {
                    composable(route = Navigation.Home.route) {
                        HomeScreen(navController)
                    }
                }
            }
        }
    }

    @Test
    fun when_starting_ui_should_displayTitle() {
//        composeTestRule.setContent {
//            navController = TestNavHostController(LocalContext.current)
//            navController.navigatorProvider.addNavigator(ComposeNavigator())
//            HomeScreen(navController = navController)
//        }
//        composeTestRule.apply {
//            onNodeWithText("Random Selected Gif").assertIsDisplayed()
//            onNodeWithText("Search Result").assertDoesNotExist()
//        }
    }
}
