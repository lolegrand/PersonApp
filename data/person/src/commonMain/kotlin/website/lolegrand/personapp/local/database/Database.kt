package website.lolegrand.personapp.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import website.lolegrand.personapp.local.model.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
@ConstructedBy(PersonAppDatabaseConstructor::class)
abstract class PersonAppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object PersonAppDatabaseConstructor : RoomDatabaseConstructor<PersonAppDatabase> {
    override fun initialize(): PersonAppDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<PersonAppDatabase>,
): PersonAppDatabase {
    return builder
        .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}