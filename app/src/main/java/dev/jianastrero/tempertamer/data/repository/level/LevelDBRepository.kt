package dev.jianastrero.tempertamer.data.repository.level

import dev.jianastrero.tempertamer.data.dao.LevelDao
import dev.jianastrero.tempertamer.domain.entity.Level
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LevelDBRepository @Inject constructor(
    private val levelDao: LevelDao
) : ILevelRepository {
    override suspend fun getLevels(): List<Level> = withContext(Dispatchers.IO) {
        levelDao.getAll()
    }

    override suspend fun insertAll(levels: List<Level>) = withContext(Dispatchers.IO) {
        levelDao.insertAll(levels)
    }

    override suspend fun deleteAll() = withContext(Dispatchers.IO) {
        levelDao.deleteAll()
    }
}
