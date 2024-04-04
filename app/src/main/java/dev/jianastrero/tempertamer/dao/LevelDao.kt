package dev.jianastrero.tempertamer.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.jianastrero.tempertamer.domain.entity.Level

@Dao
interface LevelDao {
    @Query("SELECT * FROM level")
    fun getAll(): List<Level>

    @Insert
    fun insertAll(vararg levels: Level)
}
