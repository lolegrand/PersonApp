package website.lolegrand.personapp.master

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import website.lolegrand.personapp.master.adapter.toMasterPersonUI
import website.lolegrand.personapp.master.state.MasterState
import website.lolegrand.personapp.repository.PersonRepository

class MasterViewModel(
    private val personRepository: PersonRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<MasterState>(MasterState.Loading)
    val state by lazy { _state.asStateFlow() }

    init {
        viewModelScope.launch {
            personRepository.watchAllPersons().collect { personEntity ->
                _state.emit(
                    MasterState.Success(
                        personEntity.map { it.toMasterPersonUI() }
                    )
                )
            }
        }
    }
    
}