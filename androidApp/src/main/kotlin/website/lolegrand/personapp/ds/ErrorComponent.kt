package website.lolegrand.personapp.ds

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import website.lolegrand.personapp.R
import website.lolegrand.personapp.theme.PersonAppTheme

data class ErrorAction(
    val text: String,
    val action: () -> Unit,
)

@Composable
fun ErrorComponent(
    errorAction: ErrorAction? = null,
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.error),
            contentDescription = "Error",
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "An error occurred",
            style = PersonAppTheme.typography.h1
        )

        if (errorAction != null) {
            Spacer(modifier = Modifier.height(24.dp))

            PersonAppButton(
                modifier = Modifier.width(128.dp),
                text = errorAction.text,
                onClick = errorAction.action,
                buttonType = ButtonType.ERROR
            )
        }
    }
}

@Preview
@Composable
private fun ErrorComponentPreview() {
    PersonAppTheme {
        ErrorComponent()
    }
}