package website.lolegrand.personapp.generator.state

import website.lolegrand.personapp.generator.model.GeneratorPersonUI

interface GeneratorState {

    data object Loading : GeneratorState

    data object Error : GeneratorState

    data object Idle : GeneratorState

    data class Success(
        val data: List<GeneratorPersonUI>,
    ): GeneratorState

}