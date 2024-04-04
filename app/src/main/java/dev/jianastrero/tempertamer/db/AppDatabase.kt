package dev.jianastrero.tempertamer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.jianastrero.tempertamer.domain.entity.Level

@Database(
    entities = [Level::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
}
