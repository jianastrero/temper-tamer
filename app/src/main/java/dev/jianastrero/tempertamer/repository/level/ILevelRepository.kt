package dev.jianastrero.tempertamer.repository.level


interface ILevelRepository {
    suspend fun getLevels()
}
