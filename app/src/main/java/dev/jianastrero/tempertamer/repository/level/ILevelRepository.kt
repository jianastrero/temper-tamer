package dev.jianastrero.tempertamer.repository.level

import dev.jianastrero.tempertamer.domain.entity.Level

interface ILevelRepository {
    fun getLevels(): List<Level>
}
