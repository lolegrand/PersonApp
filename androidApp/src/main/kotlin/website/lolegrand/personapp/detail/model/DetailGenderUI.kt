package website.lolegrand.personapp.detail.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import website.lolegrand.personapp.theme.PersonAppTheme

enum class DetailGenderUI {
    MALE,
    FEMALE;

    val color: Color
        @Composable
        get() = when (this) {
            MALE -> PersonAppTheme.colors.colorMale
            FEMALE -> PersonAppTheme.colors.colorFemale
        }

}