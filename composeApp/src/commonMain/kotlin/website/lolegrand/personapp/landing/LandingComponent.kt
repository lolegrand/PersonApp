package website.lolegrand.personapp.landing

import com.arkivanov.decompose.ComponentContext

interface LandingComponent {

    fun goToGenerator()

    fun goToPersonList()

}

class DefaultLandingComponent(
    componentContext: ComponentContext,
    private val onGoToGenerator: () -> Unit,
    private val onGoToPersonList: () -> Unit,
) : LandingComponent, ComponentContext by componentContext {

    override fun goToGenerator() {
        onGoToGenerator()
    }

    override fun goToPersonList() {
        onGoToPersonList()
    }

}