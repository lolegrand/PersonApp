package website.lolegrand.personapp.master.model

data class MasterPersonUI(
    val id: String,
    val name: String,
    val profilePicUrl: String,
    val email: String,
    val gender: MasterGenderUI,
)