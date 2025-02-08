package website.lolegrand.personapp.master

import com.arkivanov.decompose.ComponentContext

interface MasterComponent {

    fun onGoToDetailClicked(personId: String)

    fun onGoBackClicked()

}

class DefaultMasterComponent(
    componentContext: ComponentContext,
    private val onGoToDetail: (personId: String) -> Unit,
    private val onGoBack: () -> Unit,
) : MasterComponent, ComponentContext by componentContext {

    override fun onGoToDetailClicked(personId: String) {
        onGoToDetail(personId)
    }

    override fun onGoBackClicked() {
        onGoBack()
    }

}