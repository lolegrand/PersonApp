package website.lolegrand.personapp.generator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel
import website.lolegrand.personapp.ds.TopBar
import website.lolegrand.personapp.ds.TopBarAction
import website.lolegrand.personapp.generator.component.GeneratorError
import website.lolegrand.personapp.generator.component.GeneratorIdle
import website.lolegrand.personapp.generator.component.GeneratorLoaded
import website.lolegrand.personapp.generator.component.GeneratorLoading
import website.lolegrand.personapp.generator.state.GeneratorState

@Composable
fun GeneratorScreen(
    onBack: () -> Unit,
    generatorViewModel: GeneratorViewModel = koinViewModel(),
) {
    // State
    val state by generatorViewModel.state.collectAsState()

    // View
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        TopBar(
            leftAction = TopBarAction(
                onClick = onBack,
                icon = Icons.AutoMirrored.Filled.ArrowBack,
            ),
            title = "Person Generator",
        )

        when (val currentState = state) {
            is GeneratorState.Loading -> {
                GeneratorLoading()
            }

            is GeneratorState.Error -> {
                GeneratorError()
            }

            is GeneratorState.Success -> {
                GeneratorLoaded(
                    persons = currentState.data,
                )
            }

            is GeneratorState.Idle -> {
                GeneratorIdle(
                    onClickGenerate = {
                        generatorViewModel.generatePersons()
                    }
                )
            }
        }
    }
}