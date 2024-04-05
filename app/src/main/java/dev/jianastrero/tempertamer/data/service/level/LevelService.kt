package dev.jianastrero.tempertamer.data.service.level

import dev.jianastrero.tempertamer.data.repository.level.ILevelRepository
import dev.jianastrero.tempertamer.domain.entity.Level
import javax.inject.Inject
import javax.inject.Named

class LevelService @Inject constructor(
    @Named("level_api")
    private val levelAPIRepository: ILevelRepository,
    @Named("level_db")
    private val levelDBRepository: ILevelRepository
) : ILevelService {
    override suspend fun getLevels(): List<Level> {
        val cachedLevels = levelDBRepository.getLevels()
        if (cachedLevels.isNotEmpty()) {
            return cachedLevels
        }

        val levels = levelAPIRepository.getLevels()
        levelDBRepository.insertAll(levels)
        return levels
    }
}
