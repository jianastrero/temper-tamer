package dev.jianastrero.tempertamer.data.service.level

import dev.jianastrero.tempertamer.domain.entity.Level

interface ILevelService {
    suspend fun getLevels(): List<Level>
}
