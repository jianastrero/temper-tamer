package dev.jianastrero.tempertamer.data.usecase

import dev.jianastrero.tempertamer.data.service.level.LevelService
import javax.inject.Inject

class GetLevelsUseCase @Inject constructor(
    private val levelService: LevelService
) {
    suspend operator fun invoke() = levelService.getLevels()
}
