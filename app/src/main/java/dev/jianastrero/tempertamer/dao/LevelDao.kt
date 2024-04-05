package dev.jianastrero.tempertamer.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.jianastrero.tempertamer.domain.entity.Level

@Dao
interface LevelDao {

    @Query("SELECT * FROM Level")
    suspend fun getAll(): List<Level>

    @Insert
    suspend fun insertAll(levels: List<Level>)
}
