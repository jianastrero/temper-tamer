package dev.jianastrero.tempertamer.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.jianastrero.tempertamer.dao.LevelDao
import dev.jianastrero.tempertamer.domain.converter.EntityConverters
import dev.jianastrero.tempertamer.domain.entity.Level

@Database(
    entities = [Level::class],
    version = 1
)
@TypeConverters(EntityConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun levelDao(): LevelDao
}
