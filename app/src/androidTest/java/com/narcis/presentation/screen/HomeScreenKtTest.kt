package com.narcis.presentation.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class HomeScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_starting_ui_should_displayTitle() {
        composeTestRule.setContent {
            HomeScreen(navController = null)
        }
        composeTestRule.apply {
            onNodeWithText("Random Selected Gif").assertIsDisplayed()
            onNodeWithText("Search Result").assertDoesNotExist()

        }
    }
}
