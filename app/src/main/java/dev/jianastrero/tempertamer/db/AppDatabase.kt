package dev.jianastrero.tempertamer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.jianastrero.tempertamer.dao.LevelDao
import dev.jianastrero.tempertamer.domain.entity.Activity
import dev.jianastrero.tempertamer.domain.entity.Details
import dev.jianastrero.tempertamer.domain.entity.File
import dev.jianastrero.tempertamer.domain.entity.Icon
import dev.jianastrero.tempertamer.domain.entity.Level
import dev.jianastrero.tempertamer.domain.entity.LockedIcon

@Database(
    entities = [
        Level::class,
        Activity::class,
        Icon::class,
        LockedIcon::class,
        File::class,
        Details::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun levelDao(): LevelDao
}
