package website.lolegrand.personapp.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import website.lolegrand.personapp.local.adapter.toPersonEntityList
import website.lolegrand.personapp.local.database.PersonDao
import website.lolegrand.personapp.local.model.PersonEntity
import website.lolegrand.personapp.remote.model.PersonRequestData

class PersonRepository(
    private val client: HttpClient,
    private val personDao: PersonDao,
) {

    suspend fun generate10Person(): List<PersonEntity> {
        delay(2000)
        val personResponse = client.get("?results=10").body<PersonRequestData>()
        val entities = personResponse.toPersonEntityList()
        personDao.insertPersons(personResponse.toPersonEntityList())
        return entities
    }

    suspend fun removePerson(personId: String) {
        delay(2000)
        personDao.deletePersonById(personId)
    }

    fun watchAllPersons(): Flow<List<PersonEntity>> {
        return personDao.watchAllPersons()
    }

    suspend fun getPersonById(personId: String): PersonEntity {
        delay(2000)
        return personDao.getPersonById(personId)
    }

}