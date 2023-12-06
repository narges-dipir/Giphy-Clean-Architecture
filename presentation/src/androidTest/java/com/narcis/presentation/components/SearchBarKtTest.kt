package com.narcis.presentation.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.narcis.presentation.theme.GiphyTestTheme
import org.junit.Rule
import org.junit.Test

class SearchBarKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_hasTitle_should_display_search_and_back_arrow() {
        val textValue = "search..."
        val placeholderText = "search"
        val gifTitle = "sample title"
        val isTrailingIconVisible = false
        val showSearchView = false
        val haseTitle = true

        composeTestRule.setContent {
            GiphyTestTheme {
                SearchBar(
                    textValue = textValue,
                    valueChange = {},
                    isTrailingIconVisible = isTrailingIconVisible,
                    placeholderText = placeholderText,
                    backPress = {},
                    showSearchView = showSearchView,
                    haseTitle = haseTitle,
                    gifTitle = gifTitle,
                    naveController = null,
                )
            }
        }
        composeTestRule.apply {
            onNodeWithText(textValue).assertIsDisplayed()
//            onNodeWithText(placeholderText).assertIsNotDisplayed()
            onNodeWithContentDescription("back press").assertIsDisplayed()
            onNodeWithContentDescription("search input field").assertDoesNotExist()
            onNodeWithContentDescription("Cancel").assertDoesNotExist()
            onNodeWithContentDescription("title row").assertIsDisplayed()
        }
    }
}
