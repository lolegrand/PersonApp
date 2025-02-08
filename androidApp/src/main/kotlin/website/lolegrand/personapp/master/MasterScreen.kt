package website.lolegrand.personapp.master

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import website.lolegrand.personapp.ds.TopBar
import website.lolegrand.personapp.ds.TopBarAction
import website.lolegrand.personapp.master.component.MasterError
import website.lolegrand.personapp.master.component.MasterLoaded
import website.lolegrand.personapp.master.component.MasterLoading
import website.lolegrand.personapp.master.state.MasterState

@Composable
fun MasterScreen(
    onGoToPersonDetail: (id: String) -> Unit,
    onBack: () -> Unit,
    masterViewModel: MasterViewModel = koinViewModel(),
) {
    // State
    val state by masterViewModel.state.collectAsState()

    // View
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
    ) {
        TopBar(
            leftAction = TopBarAction(
                onClick = onBack,
                icon = Icons.AutoMirrored.Filled.ArrowBack,
            ),
            title = "Person List",
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
        ) {
            when (val currentState = state) {
                is MasterState.Loading -> {
                    MasterLoading()
                }

                is MasterState.Success -> {
                    MasterLoaded(
                        personList = currentState.data,
                        onClickPerson = { personId: String ->
                            onGoToPersonDetail(personId)
                        }
                    )
                }

                is MasterState.Error -> {
                    MasterError(onRetry = { })
                }
            }
        }
    }
}
