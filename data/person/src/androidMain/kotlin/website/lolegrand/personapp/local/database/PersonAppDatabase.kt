package website.lolegrand.personapp.local.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<PersonAppDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("person_app.db")
    return Room.databaseBuilder<PersonAppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}