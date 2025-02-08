package website.lolegrand.personapp.master.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import website.lolegrand.personapp.ds.ErrorAction
import website.lolegrand.personapp.ds.ErrorComponent

@Composable
fun MasterError(
    onRetry: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        ErrorComponent(
            errorAction = ErrorAction(
                action = onRetry,
                text = "Retry"
            )
        )
    }
}