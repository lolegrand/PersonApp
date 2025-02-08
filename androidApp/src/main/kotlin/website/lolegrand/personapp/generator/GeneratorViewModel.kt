package website.lolegrand.personapp.generator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import website.lolegrand.personapp.generator.adapter.toGeneratorPersonUI
import website.lolegrand.personapp.generator.state.GeneratorState
import website.lolegrand.personapp.repository.PersonRepository


class GeneratorViewModel(
    private val personRepository: PersonRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<GeneratorState>(GeneratorState.Idle)
    val state by lazy { _state.asStateFlow() }

    fun generatePersons() {
        viewModelScope.launch {
            _state.emit(GeneratorState.Loading)

            val personEntity = personRepository.generate10Person()
            _state.emit(
                GeneratorState.Success(
                    data = personEntity.map { it.toGeneratorPersonUI() }
                )
            )
        }
    }
}