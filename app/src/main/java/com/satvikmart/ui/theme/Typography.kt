package com.satvikmart.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val SatvikMartColorScheme = lightColorScheme(
    primary = DeepGreen,
    onPrimary = White,
    secondary = SaffronOrange,
    onSecondary = White,
    background = WarmCream,
    onBackground = Black,
    surface = White,
    onSurface = Black,
    error = ErrorRed,
    onError = White
)

@Composable
fun SatvikMartTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = SatvikMartColorScheme,
        typography = SatvikMartTypography,
        content = content
    )
}
