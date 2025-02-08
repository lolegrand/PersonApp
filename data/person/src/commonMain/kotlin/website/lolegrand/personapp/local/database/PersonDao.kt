package website.lolegrand.personapp.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import website.lolegrand.personapp.local.model.PersonEntity

@Dao
interface PersonDao {

    @Query("SELECT * FROM PersonEntity")
    fun watchAllPersons(): Flow<List<PersonEntity>>

    @Query("SELECT * FROM PersonEntity WHERE id = :id")
    suspend fun getPersonById(id: String): PersonEntity

    @Insert
    suspend fun insertPersons(persons: List<PersonEntity>)

    @Query("DELETE FROM PersonEntity WHERE id = :id")
    suspend fun deletePersonById(id: String)

}