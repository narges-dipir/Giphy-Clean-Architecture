package com.narcis.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.narcis.presentation.navigation.Navigation
import com.narcis.presentation.theme.ApplicationTheme
import com.narcis.presentation.theme.PicnicTestTheme
import com.narcis.presentation.theme.gray01

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    textValue: String,
    valueChange: (String) -> Unit = {},
    isTrailingIconVisible: Boolean,
    placeholderText: String,
    backPress: () -> Unit = {},
    showBackArrow: Boolean = true,
    showSearchView: Boolean = true,
    haseTitle: Boolean = false,
    gifTitle: String = "Gif_Title",
    naveController: NavController?,
) {
    val focusManager = LocalFocusManager.current
    val backArrowVisibility by remember {
        mutableStateOf(showBackArrow)
    }
    val searchViewVisibility by remember {
        mutableStateOf(showSearchView)
    }
    BackHandler(
        onBack = {
            valueChange("")
        },
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (backArrowVisibility) {
            IconButton(
                onClick = {
                    valueChange("")
                    naveController?.popBackStack(route = Navigation.Home.route, inclusive = false)
                },
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back press",
                    modifier = modifier
                        .background(color = ApplicationTheme.colors.iconBackGround)
                        .padding(8.dp),
                )
            }
        }
        if (searchViewVisibility) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, top = 24.dp, bottom = 16.dp, start = 8.dp),
                value = textValue,
                onValueChange = valueChange,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    autoCorrect = false,
                    capitalization = KeyboardCapitalization.None,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    },
                ),
                singleLine = true,
                maxLines = 1,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = gray01,
                    )
                },
                trailingIcon = {
                    if (isTrailingIconVisible) {
                        IconButton(onClick = { valueChange("") }) {
                            Icon(
                                imageVector = Icons.Default.Cancel,
                                contentDescription = "Cancel",
                                tint = gray01,
                            )
                        }
                    }
                },
                textStyle = TextStyle(
                    color = ApplicationTheme.colors.textPrimary,
                ),
                placeholder = {
                    Text(
                        color = gray01,
                        text = placeholderText,
                    )
                },
                shape = MaterialTheme.shapes.large,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = ApplicationTheme.colors.textSecondry,
                    unfocusedContainerColor = ApplicationTheme.colors.textSecondry,
                    disabledContainerColor = ApplicationTheme.colors.textSecondry,
                    cursorColor = ApplicationTheme.colors.textPrimary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
            )
        } else if (haseTitle) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = textValue,
                    fontSize = 20.sp,
                    color = ApplicationTheme.colors.textPrimary,
                    modifier = modifier.padding(32.dp),
                )
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    PicnicTestTheme {
        SearchBar(
            textValue = "search...",
            valueChange = {},
            isTrailingIconVisible = false,
            placeholderText = "search",
            backPress = {},
            showSearchView = false,
            haseTitle = true,
            gifTitle = "sample title",
            naveController = null,

        )
    }
}

@Composable
@Preview
private fun PreviewSearchOnly() {
    PicnicTestTheme {
        SearchBar(
            textValue = "search...",
            valueChange = {},
            isTrailingIconVisible = false,
            placeholderText = "search",
            backPress = {},
            showBackArrow = false,
            naveController = null,

        )
    }
}

@Composable
@Preview
private fun PreviewBackArrowOnly() {
    PicnicTestTheme {
        SearchBar(
            textValue = "search...",
            valueChange = {},
            isTrailingIconVisible = false,
            placeholderText = "search",
            backPress = {},
            showSearchView = false,
            naveController = null,

        )
    }
}
