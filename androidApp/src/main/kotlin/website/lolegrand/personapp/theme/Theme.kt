package website.lolegrand.personapp.theme

import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color


@Composable
fun PersonAppTheme(content: @Composable () -> Unit) {

    // Default colors
    val defaultColors = PersonAppColors(
        primary = Color(0xFF70ACDC),
        onPrimary = Color(0xFFFFFFFF),

        secondary = Color(0xFFF29413),
        onSecondary = Color(0xFFFFFFFF),

        tertiary = Color(0xFF3470A0),

        onSurfaceVariant = Color(0xFF3470A0),
        onSurface = Color(0xFF163752),

        error = Color(0xFFA52020),

        surfaceContainer = Color(0xFFFFFFFF),
        surfaceContainerHigh = Color(0xFFF2F8FC),
        surfaceContainerHighest = Color(0xFFD6E6F5),

        colorMale = Color(0xFF70ACDC),
        colorFemale = Color(0xFFE07A7A),
    )

    CompositionLocalProvider(
        LocalColors provides defaultColors,
        LocalTypography provides Typography
    ) {
        ProvideTextStyle(value = Typography.p2) {
            content()
        }
    }
}

object PersonAppTheme {
    val colors: PersonAppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: PersonAppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
