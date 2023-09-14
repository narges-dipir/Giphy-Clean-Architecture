package com.narcis.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.narcis.presentation.theme.ApplicationTheme
import com.narcis.presentation.theme.PicnicTestTheme

@Composable
fun CircleTextView(
    modifier: Modifier = Modifier,
    text: String,
    size: TextUnit = 16.sp,
) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(50))
            .background(color = ApplicationTheme.colors.iconBackGround),
    ) {
        Text(
            text = text,
            color = ApplicationTheme.colors.textPrimary,
            modifier = Modifier.padding(8.dp),
            fontSize = size,
            maxLines = 1,
        )
    }
}

@Preview
@Composable
private fun Preview() {
    PicnicTestTheme {
        CircleTextView(modifier = Modifier.size(84.dp), text = "+18")
    }
}
