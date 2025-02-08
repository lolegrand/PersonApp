package website.lolegrand.personapp.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel
import website.lolegrand.personapp.detail.component.DetailError
import website.lolegrand.personapp.detail.component.DetailLoaded
import website.lolegrand.personapp.detail.component.DetailLoading
import website.lolegrand.personapp.detail.state.DetailState

@Composable
fun DetailScreen(
    onBack: () -> Unit,
    detailViewModel: DetailViewModel = koinViewModel(),
) {
    // State
    val state by detailViewModel.state.collectAsState()

    // Effect
    LaunchedEffect(Unit) {
        detailViewModel.personLookups()
    }

    // View
    when (val currentState = state) {
        is DetailState.Loading -> {
            DetailLoading()
        }

        is DetailState.Error -> {
            DetailError()
        }

        is DetailState.Success -> {
            DetailLoaded(
                person = currentState.data,
                onBack = onBack,
                onDelete = {
                    detailViewModel.deletePerson()
                },
            )
        }

        is DetailState.RemoveCompleted -> {
            LaunchedEffect(Unit) {
                onBack()
            }
        }
    }

}