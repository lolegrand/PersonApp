package website.lolegrand.personapp.generator.model

data class GeneratorPersonUI(
    val id: String,
    val name: String,
    val gender: GeneratorGenderUI,
    val profilePictureUrl: String,
)