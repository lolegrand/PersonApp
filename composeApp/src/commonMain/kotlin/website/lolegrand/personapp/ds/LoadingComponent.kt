package website.lolegrand.personapp.ds

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import website.lolegrand.personapp.theme.PersonAppTheme

@Composable
fun LoadingComponent() {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        AnimatedLoader(
            loaderColor = PersonAppTheme.colors.secondary,
            progress = 1f,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(58.dp))

        Text(
            text = "Loading please wait",
            style = PersonAppTheme.typography.h1
        )
    }
}
