package website.lolegrand.personapp

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import website.lolegrand.personapp.detail.DefaultDetailComponent
import website.lolegrand.personapp.detail.DetailComponent
import website.lolegrand.personapp.generator.DefaultGeneratorComponent
import website.lolegrand.personapp.generator.GeneratorComponent
import website.lolegrand.personapp.landing.DefaultLandingComponent
import website.lolegrand.personapp.landing.LandingComponent
import website.lolegrand.personapp.master.DefaultMasterComponent
import website.lolegrand.personapp.master.MasterComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class LandingChild(val component: LandingComponent) : Child()
        class MasterChild(val component: MasterComponent) : Child()
        class DetailChild(val component: DetailComponent) : Child()
        class GeneratorChild(val component: GeneratorComponent) : Child()
    }
}

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Landing,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            is Config.Landing -> RootComponent.Child.LandingChild(landingComponent(componentContext))
            is Config.Master -> RootComponent.Child.MasterChild(masterComponent(componentContext))
            is Config.Detail -> RootComponent.Child.DetailChild(detailComponent(componentContext, config))
            is Config.Generator -> RootComponent.Child.GeneratorChild(generatorComponent(componentContext))
        }

    @OptIn(DelicateDecomposeApi::class)
    private fun masterComponent(componentContext: ComponentContext): MasterComponent {
        return DefaultMasterComponent(
            componentContext = componentContext,
            onGoToDetail = { personId ->
                navigation.push(Config.Detail(personId))
            },
            onGoBack = { navigation.pop() },
        )
    }

    @OptIn(DelicateDecomposeApi::class)
    private fun landingComponent(componentContext: ComponentContext): LandingComponent {
        return DefaultLandingComponent(
            componentContext = componentContext,
            onGoToGenerator = { navigation.push(Config.Generator) },
            onGoToPersonList = { navigation.push(Config.Master) },
        )
    }

    private fun generatorComponent(componentContext: ComponentContext): GeneratorComponent {
        return DefaultGeneratorComponent(componentContext = componentContext)
    }

    private fun detailComponent(componentContext: ComponentContext, config: Config.Detail): DetailComponent {
        return DefaultDetailComponent(
            componentContext = componentContext,
            personId = config.personId,
            onClose = { navigation.pop() },
        )
    }

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Landing : Config

        @Serializable
        data object Master : Config

        @Serializable
        data object Generator : Config

        @Serializable
        data class Detail(val personId: String) : Config

    }
}