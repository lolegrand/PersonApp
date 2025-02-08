package website.lolegrand.personapp.di

import org.koin.dsl.module
import website.lolegrand.personapp.local.database.getRoomDatabase
import website.lolegrand.personapp.remote.network.createHttpClient
import website.lolegrand.personapp.repository.PersonRepository

val commonModule = module {
    single { createHttpClient() }
    single { getRoomDatabase(get()).personDao() }
    single { PersonRepository(get(), get()) }
}