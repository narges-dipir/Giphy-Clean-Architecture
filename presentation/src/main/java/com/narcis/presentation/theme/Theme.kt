package com.narcis.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = ApplicationColors(
    gradiantBackground = listOf(Shadow11, Shadow7, Shadow4, Lavender7),
    uiBackground = FunctionalDarkGrey,
    textPrimary = Neutral0,
    textSecondry = Neutral4,
    textHelp = Neutral6,
    iconGradiant = listOf(Ocean9, Shadow11),
    welcomeGradiant = listOf(Shadow12, Ocean12),
    error = FunctionalRedDark,
    navigationPrimary = Neutral3,
    iconInteractiveInactive = Neutral6,
    iconBackGround = Neutral3,
    isDark = true,
)

private val LightColorPalette = ApplicationColors(
    gradiantBackground = listOf(Shadow11, Shadow7, Shadow4, Lavender7),
    uiBackground = Neutral0,
    textPrimary = Neutral7,
    textSecondry = Neutral5,
    textHelp = Neutral1,
    iconGradiant = listOf(Ocean9, Shadow11),
    welcomeGradiant = listOf(Shadow12, Ocean12),
    error = FunctionalRed,
    navigationPrimary = Lavender2,
    iconInteractiveInactive = Neutral1,
    iconBackGround = Neutral5,
    isDark = false,
)

@Composable
fun GiphyTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorPalette = if (darkTheme) DarkColorPalette else LightColorPalette
    val sysController = rememberSystemUiController()
    SideEffect {
        sysController.setSystemBarsColor(
            color = colorPalette.uiBackground.copy(AlphaNearOpaque),
        )
    }
    ProvideApplicationColors(colors = colorPalette) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            typography = Typography,
            shapes = Shapes,
            content = content,
        )
    }
}

private val LocalApplicationColor = staticCompositionLocalOf<ApplicationColors> {
    error("no palette provided")
}

object ApplicationTheme {
    val colors: ApplicationColors
        @Composable
        get() = LocalApplicationColor.current
}

@Composable
fun ProvideApplicationColors(
    colors: ApplicationColors,
    content: @Composable () -> Unit,
) {
    val colorPalette = remember {
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalApplicationColor provides colorPalette, content = content)
}

@Stable
class ApplicationColors(
    gradiantBackground: List<Color>,
    uiBackground: Color,
    textPrimary: Color,
    textSecondry: Color,
    textHelp: Color,
    iconGradiant: List<Color>,
    welcomeGradiant: List<Color>,
    error: Color,
    navigationPrimary: Color,
    iconInteractiveInactive: Color,
    iconBackGround: Color,
    isDark: Boolean,
) {
    var gradiantBackground by mutableStateOf(gradiantBackground)
        private set
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set

    var textSecondry by mutableStateOf(textSecondry)
        private set
    var textHelp by mutableStateOf(textHelp)
        private set
    var iconGradiant by mutableStateOf(iconGradiant)
        private set

    var welcomeGradiant by mutableStateOf(welcomeGradiant)
        private set
    var error by mutableStateOf(error)
        private set
    var isDark by mutableStateOf(isDark)
        private set
    var navigationPrimary by mutableStateOf(navigationPrimary)
        private set

    var iconInteractiveInactive by mutableStateOf(iconInteractiveInactive)
        private set

    var iconBackGround by mutableStateOf(iconBackGround)
    fun update(other: ApplicationColors) {
        gradiantBackground = other.gradiantBackground
        uiBackground = other.uiBackground
        textPrimary = other.textPrimary
        textSecondry = other.textSecondry
        textHelp = other.textHelp
        iconGradiant = other.iconGradiant
        welcomeGradiant = other.welcomeGradiant
        error = other.error
        navigationPrimary = other.navigationPrimary
        iconInteractiveInactive = other.iconInteractiveInactive
        iconBackGround = other.iconBackGround
        isDark = other.isDark
    }

    fun copy(): ApplicationColors = ApplicationColors(
        gradiantBackground = gradiantBackground,
        uiBackground = uiBackground,
        textPrimary = textPrimary,
        textSecondry = textSecondry,
        textHelp = textHelp,
        iconGradiant = iconGradiant,
        welcomeGradiant = welcomeGradiant,
        error = error,
        navigationPrimary = navigationPrimary,
        iconInteractiveInactive = iconInteractiveInactive,
        iconBackGround = iconBackGround,
        isDark = isDark,
    )
}
fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta,
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme,
)
