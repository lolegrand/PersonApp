package website.lolegrand.personapp.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp


@Immutable
data class PersonAppTypography(
    val h1: TextStyle,
    val b1: TextStyle,
    val sm1: TextStyle,
    val p1: TextStyle,
    val b2: TextStyle,
    val sm2: TextStyle,
    val p2: TextStyle,
    val italic2: TextStyle,
    val link2: TextStyle,
    val sm3: TextStyle,
    val buttons: TextStyle,
)

val Typography = PersonAppTypography(
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    b1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    sm1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    p1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    b2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    sm2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    p2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    italic2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        fontStyle = FontStyle.Italic
    ),
    link2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        textDecoration = TextDecoration.Underline
    ),
    sm3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp
    ),
    buttons = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp
    )
)

val LocalTypography = staticCompositionLocalOf {
    PersonAppTypography(
        h1 = TextStyle.Default,
        b1 = TextStyle.Default,
        sm1 = TextStyle.Default,
        p1 = TextStyle.Default,
        b2 = TextStyle.Default,
        sm2 = TextStyle.Default,
        p2 = TextStyle.Default,
        italic2 = TextStyle.Default,
        link2 = TextStyle.Default,
        sm3 = TextStyle.Default,
        buttons = TextStyle.Default
    )
}