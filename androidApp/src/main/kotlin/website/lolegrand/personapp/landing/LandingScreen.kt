package website.lolegrand.personapp.landing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import website.lolegrand.personapp.ds.TopBar
import website.lolegrand.personapp.landing.component.LandingLoaded

@Composable
fun LandingScreen(
    onClickGeneratePerson: () -> Unit,
    onClickGoToPersonList: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
    ) {
        TopBar(
            title = "Person App",
        )

        LandingLoaded(
            onClickGeneratePerson = onClickGeneratePerson,
            onClickGoToPersonList = onClickGoToPersonList,
        )
    }
}