package website.lolegrand.personapp.detail.adapter

import website.lolegrand.personapp.detail.model.DetailGenderUI
import website.lolegrand.personapp.detail.model.DetailPersonUI
import website.lolegrand.personapp.local.model.GenderEntity
import website.lolegrand.personapp.local.model.PersonEntity

fun PersonEntity.toDetailPersonUI(): DetailPersonUI =
    DetailPersonUI(
        id = id,
        name = name,
        address = address,
        longitude = longitude,
        latitude = latitude,
        email = email,
        age = age,
        phone = phone,
        cell = cell,
        pictureUrl = pictureUrl,
        gender = gender.toDetailGenderUI(),
    )

fun GenderEntity.toDetailGenderUI(): DetailGenderUI =
    when (this) {
        GenderEntity.MALE -> DetailGenderUI.MALE
        GenderEntity.FEMALE -> DetailGenderUI.FEMALE
    }