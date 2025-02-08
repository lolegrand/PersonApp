package website.lolegrand.personapp.landing.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import website.lolegrand.personapp.ds.ButtonType
import website.lolegrand.personapp.ds.PersonAppButton
import website.lolegrand.personapp.theme.PersonAppTheme

@Composable
fun LandingLoaded(
    onClickGeneratePerson: () -> Unit,
    onClickGoToPersonList: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        PersonAppButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Generate 10 new person",
            onClick = onClickGeneratePerson
        )

        Spacer(modifier = Modifier.height(16.dp))

        PersonAppButton(
            modifier = Modifier.fillMaxWidth(),
            text = "See my person list",
            onClick = onClickGoToPersonList,
            buttonType = ButtonType.SECONDARY,
        )

    }
}

@Preview(showSystemUi = true)
@Composable
private fun LandingLoadedPreview() {
    PersonAppTheme {
        LandingLoaded(
            onClickGeneratePerson = {},
            onClickGoToPersonList = {},
        )
    }
}