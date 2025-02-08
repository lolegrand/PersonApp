package website.lolegrand.personapp.generator.adapter

import website.lolegrand.personapp.generator.model.GeneratorGenderUI
import website.lolegrand.personapp.generator.model.GeneratorPersonUI
import website.lolegrand.personapp.local.model.GenderEntity
import website.lolegrand.personapp.local.model.PersonEntity

fun PersonEntity.toGeneratorPersonUI() = GeneratorPersonUI(
    id = id,
    name = name,
    gender = gender.toGeneratorGenderUI(),
    profilePictureUrl = pictureUrl,
)

fun GenderEntity.toGeneratorGenderUI() = when (this) {
    GenderEntity.MALE -> GeneratorGenderUI.MALE
    GenderEntity.FEMALE -> GeneratorGenderUI.FEMALE
}