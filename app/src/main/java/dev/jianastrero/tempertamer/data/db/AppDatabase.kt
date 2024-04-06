package dev.jianastrero.tempertamer.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.jianastrero.tempertamer.data.dao.LevelDao
import dev.jianastrero.tempertamer.data.converter.EntityConverters
import dev.jianastrero.tempertamer.domain.entity.Level

@Database(
    entities = [Level::class],
    version = 1
)
@TypeConverters(EntityConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun levelDao(): LevelDao
}
