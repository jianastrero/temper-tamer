package dev.jianastrero.tempertamer.repository.level

import dev.jianastrero.tempertamer.dao.LevelDao
import dev.jianastrero.tempertamer.domain.entity.Level
import javax.inject.Inject

class LevelDBRepository @Inject constructor(
    private val levelDao: LevelDao
) : ILevelRepository {
    override suspend fun getLevels(): List<Level> =
        levelDao.getAll()

    override suspend fun insertAll(levels: List<Level>) =
        levelDao.insertAll(levels)
}
