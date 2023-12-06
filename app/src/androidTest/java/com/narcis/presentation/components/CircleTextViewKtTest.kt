package com.narcis.presentation.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.narcis.presentation.theme.GiphyTestTheme
import org.junit.Rule
import org.junit.Test

class CircleTextViewKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_circleTextViewTest_should_showExpectedContent() {
        val title = "Title"
        composeTestRule.setContent {
            GiphyTestTheme {
                CircleTextView(text = title)
            }
        }
        composeTestRule.apply {
            onNodeWithText(title).assertIsDisplayed()
        }
    }

    @Test
    fun when_circleTextViewTest_should_showEmptyContent() {
        val title = ""
        composeTestRule.setContent {
            GiphyTestTheme {
                CircleTextView(text = title)
            }
        }
        composeTestRule.apply {
            onNodeWithText(title).assertIsNotDisplayed()
        }
    }
}
