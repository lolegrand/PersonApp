package website.lolegrand.personapp.di

import org.koin.dsl.module
import website.lolegrand.personapp.local.database.getDatabaseBuilder

actual val sharedModule = module {
    single { getDatabaseBuilder() }
}

