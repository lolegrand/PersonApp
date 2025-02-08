package website.lolegrand.personapp.master.state

import website.lolegrand.personapp.master.model.MasterPersonUI

interface MasterState {

    data object Loading : MasterState

    data object Error : MasterState

    data class Success(
        val data: List<MasterPersonUI>,
    ) : MasterState

}