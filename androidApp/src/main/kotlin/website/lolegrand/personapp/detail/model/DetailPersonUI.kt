package website.lolegrand.personapp.detail.model

data class DetailPersonUI(
    val gender: DetailGenderUI,
    val name: String,
    val address: String,
    val longitude: Float,
    val latitude: Float,
    val email: String,
    val age: Int,
    val id: String,
    val phone: String,
    val cell: String,
    val pictureUrl: String,
)