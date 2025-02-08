package website.lolegrand.personapp.generator

import com.arkivanov.decompose.ComponentContext

interface GeneratorComponent

class DefaultGeneratorComponent(
    componentContext: ComponentContext,
) : GeneratorComponent, ComponentContext by componentContext