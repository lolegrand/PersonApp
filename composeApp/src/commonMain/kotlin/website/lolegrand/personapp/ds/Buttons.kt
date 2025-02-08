package website.lolegrand.personapp.ds

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import website.lolegrand.personapp.theme.PersonAppTheme

enum class ButtonType {
    PRIMARY,
    SECONDARY,
    ERROR;

    val containerColor: Color
        @Composable
        get() = when (this) {
            PRIMARY -> PersonAppTheme.colors.primary
            SECONDARY -> PersonAppTheme.colors.secondary
            ERROR -> PersonAppTheme.colors.error
        }

    val contentColor: Color
        @Composable
        get() = when (this) {
            PRIMARY -> PersonAppTheme.colors.onPrimary
            SECONDARY -> PersonAppTheme.colors.onSecondary
            ERROR -> PersonAppTheme.colors.onSecondary
        }

}

@Composable
fun PersonAppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonType: ButtonType = ButtonType.PRIMARY,
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonType.containerColor,
            contentColor = buttonType.contentColor,
        )
    ) {
        Text(
            text = text,
            style = PersonAppTheme.typography.buttons
        )
    }
}
