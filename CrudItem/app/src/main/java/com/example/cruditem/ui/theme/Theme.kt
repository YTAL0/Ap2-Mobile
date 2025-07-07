package com.example.cruditem.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = RosaPastelPrincipal,
    secondary = RosaPastelPrincipal,
    background = Color(0xFF1C1C1E),
    surface = Color(0xFF2C2C2E)
)

private val LightColorScheme = lightColorScheme(
    primary = RosaPastelPrincipal,
    secondary = RosaPastelPrincipal,
    tertiary = RosaPastelPrincipal,

    background = VerdePastelFundo,
    surface = VerdePastelFundo,
    onPrimary = BrancoTexto,
    onSecondary = BrancoTexto,
    onBackground = PretoTexto,
    onSurface = PretoTexto
)

@Composable
fun CrudItemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}