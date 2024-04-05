package dev.jianastrero.tempertamer.data.repository.level

import dev.jianastrero.tempertamer.domain.entity.Level


interface ILevelRepository {
    suspend fun getLevels(): List<Level>
    suspend fun insertAll(levels: List<Level>)
}
