package website.lolegrand.personapp.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PersonRequestData(
    val results: List<PersonData>,
    val info: InfoData,
) {

    @Serializable
    data class PersonData(
        val gender: GenderData,
        val name: NameData,
        val location: LocationData,
        val email: String,
        val login: LoginData,
        val dob: DobData,
        val registered: DobData,
        val phone: String,
        val cell: String,
        val id: IdData,
        val picture: PictureData,
        val nat: String,
    ) {

        @Serializable
        enum class GenderData {

            @SerialName("female")
            FEMALE,

            @SerialName("male")
            MALE;
        }

        @Serializable
        data class NameData(
            val title: String,
            val first: String,
            val last: String,
        )

        @Serializable
        data class LocationData(
            val street: StreetData,
            val city: String,
            val state: String,
            val country: String,
            val postcode: String,
            val coordinates: CoordinatesData,
            val timezone: TimezoneData,
        ) {

            @Serializable
            data class StreetData(
                val number: Int,
                val name: String,
            )

            @Serializable
            data class CoordinatesData(
                val latitude: Float,
                val longitude: Float,
            )

            @Serializable
            data class TimezoneData(
                val offset: String,
                val description: String,
            )
        }

        @Serializable
        data class LoginData(
            val uuid: String,
            val username: String,
            val password: String,
            val salt: String,
            val md5: String,
            val sha1: String,
            val sha256: String,
        )

        @Serializable
        data class DobData(
            val date: String,
            val age: Int,
        )

        @Serializable
        data class IdData(
            val name: String,
            val value: String?,
        )

        @Serializable
        data class PictureData(
            val large: String,
            val medium: String,
            val thumbnail: String,
        )
    }

    @Serializable
    data class InfoData(
        val seed: String,
        val results: Int,
        val page: Int,
        val version: String,
    )

}

