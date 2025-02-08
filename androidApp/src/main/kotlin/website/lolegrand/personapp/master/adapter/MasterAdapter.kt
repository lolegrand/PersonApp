package website.lolegrand.personapp.master.adapter

import website.lolegrand.personapp.local.model.GenderEntity
import website.lolegrand.personapp.local.model.PersonEntity
import website.lolegrand.personapp.master.model.MasterGenderUI
import website.lolegrand.personapp.master.model.MasterPersonUI

fun PersonEntity.toMasterPersonUI() = MasterPersonUI(
    id = id,
    name = name,
    email = email,
    profilePicUrl = pictureUrl,
    gender = gender.toMasterGenderUI(),
)

fun GenderEntity.toMasterGenderUI() = when (this) {
    GenderEntity.MALE -> MasterGenderUI.MALE
    GenderEntity.FEMALE -> MasterGenderUI.FEMALE
}