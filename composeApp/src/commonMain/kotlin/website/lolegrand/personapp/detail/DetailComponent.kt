package website.lolegrand.personapp.detail

import com.arkivanov.decompose.ComponentContext

interface DetailComponent {

    fun onGoBackClicked()

    fun onDeleteClicked()

}

class DefaultDetailComponent(
    componentContext: ComponentContext,
    personId: String,
    private val onGoBack: () -> Unit,
) : DetailComponent, ComponentContext by componentContext {

    override fun onGoBackClicked() {
        onGoBack()
    }

    override fun onDeleteClicked() {
        onDeleteClicked()
    }

}