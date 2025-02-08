package website.lolegrand.personapp.generator.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import website.lolegrand.personapp.theme.PersonAppTheme

@Composable
fun GeneratorLoading() {
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center,
    ) {

        CircularProgressIndicator(
            color = PersonAppTheme.colors.secondary,
        )

    }
}