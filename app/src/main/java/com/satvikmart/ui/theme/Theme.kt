package com.satvikmart.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val SatvikMartColorScheme = lightColorScheme(
    primary = DeepGreen,
    onPrimary = White,
    primaryContainer = LightGreen,
    onPrimaryContainer = DeepGreen,
    secondary = SaffronOrange,
    onSecondary = White,
    secondaryContainer = Color(0xFFFFE0B2),
    onSecondaryContainer = DeepOrange,
    tertiary = FreshGreen,
    onTertiary = White,
    tertiaryContainer = LightGreen,
    onTertiaryContainer = DeepGreen,
    error = ErrorRed,
    onError = White,
    errorContainer = Color(0xFFFFCDD2),
    onErrorContainer = ErrorRed,
    background = WarmCream,
    onBackground = Black,
    surface = White,
    onSurface = Black,
    surfaceVariant = LightGray,
    onSurfaceVariant = MediumGray,
    outline = BorderGray,
    outlineVariant = Color(0xFFCACACB),
    scrim = Black.copy(alpha = 0.32f)
)

@Composable
fun SatvikMartTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SatvikMartColorScheme,
        typography = SatvikMartTypography,
        shapes = SatvikMartShapes,
        content = content
    )
}

import androidx.compose.ui.graphics.Color
