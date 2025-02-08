package website.lolegrand.personapp.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity
data class PersonEntity(
    @PrimaryKey val id: String,
    val name: String,
    val address: String,
    val longitude: Float,
    val latitude: Float,
    val email: String,
    val age: Int,
    val phone: String,
    val cell: String,
    val pictureUrl: String,
    val gender: GenderEntity,
)

enum class GenderEntity {
    MALE,
    FEMALE;
}

class GenderEntityConverter {

    @TypeConverter
    fun restoreGenderEntity(value: String): GenderEntity = GenderEntity.valueOf(value)

    @TypeConverter
    fun saveGenderEntity(value: GenderEntity): String = value.name

}