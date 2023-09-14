package com.narcis.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.sp
import com.narcis.presentation.MainActivity
import org.junit.Rule
import org.junit.Test

class CircleTextViewKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testCircleTextViewContent() {
        val text = "+12"
        val textSize = 20.sp

        composeTestRule.setContent {
            CircleTextView(
                text = text,
                size = textSize,
                modifier = Modifier.fillMaxSize(),
            )
        }

        composeTestRule.onNodeWithTag("CircleTextView").assertIsDisplayed()

        composeTestRule.onNodeWithText(text).assertTextEquals(text)
    }

    @Test
    fun testCircleTextViewClick() {
        var clickCount by mutableStateOf(0)

        composeTestRule.setContent {
            CircleTextView(
                text = clickCount.toString(),
                size = 20.sp,
                modifier = Modifier.fillMaxSize().clickable {
                    clickCount++
                },
            )
        }

        composeTestRule.onNodeWithTag("CircleTextView").assertIsDisplayed()

        composeTestRule.onNodeWithTag("CircleTextView").performClick()
        composeTestRule.onNodeWithTag("CircleTextView").performClick()
        composeTestRule.onNodeWithTag("CircleTextView").performClick()

        composeTestRule.onNodeWithText("3").assertIsDisplayed()
    }
}
