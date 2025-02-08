package website.lolegrand.personapp.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import website.lolegrand.personapp.detail.adapter.toDetailPersonUI
import website.lolegrand.personapp.detail.state.DetailState
import website.lolegrand.personapp.navigation.destination.DetailDestination
import website.lolegrand.personapp.repository.PersonRepository

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val personRepository: PersonRepository,
) : ViewModel() {

    private val personId = savedStateHandle.toRoute<DetailDestination>().personId

    private val _state = MutableStateFlow<DetailState>(DetailState.Loading)
    val state by lazy { _state }

    fun personLookups() {
        viewModelScope.launch {
            _state.emit(DetailState.Loading)

            val personEntity = personRepository.getPersonById(personId)

            _state.emit(
                DetailState.Success(
                    data = personEntity.toDetailPersonUI()
                )
            )
        }
    }

    fun deletePerson() {
        viewModelScope.launch {
            _state.emit(DetailState.Loading)

            personRepository.removePerson(personId)

            _state.emit(DetailState.RemoveCompleted)
        }
    }

}