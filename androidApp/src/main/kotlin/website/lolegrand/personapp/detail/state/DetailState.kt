package website.lolegrand.personapp.detail.state

import website.lolegrand.personapp.detail.model.DetailPersonUI

interface DetailState {

    data object Loading : DetailState

    data object Error : DetailState

    data class Success(
        val data: DetailPersonUI,
    ) : DetailState

    data object RemoveCompleted : DetailState
}