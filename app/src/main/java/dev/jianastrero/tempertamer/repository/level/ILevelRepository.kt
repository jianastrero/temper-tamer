package dev.jianastrero.tempertamer.repository.level

import dev.jianastrero.tempertamer.domain.entity.Level

interface ILevelRepository {
    suspend fun getLevels(): List<Level>
}
