package website.lolegrand.personapp.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class PersonAppColors(
    val primary: Color,
    val onPrimary: Color,

    val secondary: Color,
    val onSecondary: Color,

    val tertiary: Color,

    val onSurfaceVariant: Color,
    val onSurface: Color,

    val error: Color,

    val surfaceContainer: Color,
    val surfaceContainerHigh: Color,
    val surfaceContainerHighest: Color,

    val colorMale: Color,
    val colorFemale: Color,
)

val LocalColors = staticCompositionLocalOf {
    PersonAppColors(
        primary = Color.Unspecified,
        onPrimary = Color.Unspecified,

        secondary = Color.Unspecified,
        onSecondary = Color.Unspecified,

        tertiary = Color.Unspecified,

        onSurfaceVariant = Color.Unspecified,
        onSurface = Color.Unspecified,

        error = Color.Unspecified,

        surfaceContainer = Color.Unspecified,
        surfaceContainerHigh = Color.Unspecified,
        surfaceContainerHighest = Color.Unspecified,

        colorMale = Color.Unspecified,
        colorFemale = Color.Unspecified,
    )
}
