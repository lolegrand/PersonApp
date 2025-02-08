package website.lolegrand.personapp.local.adapter

import website.lolegrand.personapp.local.model.GenderEntity
import website.lolegrand.personapp.local.model.PersonEntity
import website.lolegrand.personapp.remote.model.PersonRequestData

internal fun PersonRequestData.toPersonEntityList() = results.map { personData ->
    PersonEntity(
        id = personData.login.uuid,
        name = "${personData.name.title} ${personData.name.first} ${personData.name.last}",
        address = "${personData.location.street.number} ${personData.location.street.name}, ${personData.location.city}, ${personData.location.state}, ${personData.location.country}, ${personData.location.postcode}",
        longitude = personData.location.coordinates.longitude,
        latitude = personData.location.coordinates.latitude,
        email = personData.email,
        age = personData.dob.age,
        phone = personData.phone,
        cell = personData.cell,
        pictureUrl = personData.picture.large,
        gender = personData.gender.toGenderEntity()
    )
}

internal fun PersonRequestData.PersonData.GenderData.toGenderEntity() = when (this) {
    PersonRequestData.PersonData.GenderData.MALE -> GenderEntity.MALE
    PersonRequestData.PersonData.GenderData.FEMALE -> GenderEntity.FEMALE
}
