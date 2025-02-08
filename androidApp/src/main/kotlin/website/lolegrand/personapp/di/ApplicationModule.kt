package website.lolegrand.personapp.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import website.lolegrand.personapp.detail.DetailViewModel
import website.lolegrand.personapp.generator.GeneratorViewModel
import website.lolegrand.personapp.master.MasterViewModel

val appModule = module {
    viewModelOf(::DetailViewModel)
    viewModelOf(::MasterViewModel)
    viewModelOf(::GeneratorViewModel)
    includes(personModule)
}