package website.lolegrand.personapp.generator.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import website.lolegrand.personapp.R
import website.lolegrand.personapp.ds.PersonAppButton

@Composable
fun GeneratorIdle(
    onClickGenerate: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.create),
            contentDescription = "Generator",
        )

        Spacer(modifier = Modifier.height(24.dp))

        PersonAppButton(
            text = "Generate Person",
            onClick = onClickGenerate,
        )
    }
}