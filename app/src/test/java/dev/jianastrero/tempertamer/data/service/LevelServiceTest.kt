package dev.jianastrero.tempertamer.data.service

import dev.jianastrero.tempertamer.data.repository.level.ILevelRepository
import dev.jianastrero.tempertamer.data.service.level.LevelService
import dev.jianastrero.tempertamer.domain.entity.Level
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class LevelServiceTest {

    private lateinit var levelService: LevelService
    private val mockDBLevelRepository = Mockito.mock<ILevelRepository>()
    private val mockAPILevelRepository = Mockito.mock<ILevelRepository>()
    private val mockDBLevels = mutableListOf<Level>()
    private val mockAPILevels = mutableListOf<Level>()

    @Before
    fun setup() {
        runBlocking {
            Mockito.`when`(mockDBLevelRepository.getLevels()).thenReturn(mockDBLevels)
            Mockito.`when`(mockDBLevelRepository.insertAll(Mockito.anyList())).then {
                mockDBLevels.addAll(it.getArgument(0))
            }
            Mockito.`when`(mockDBLevelRepository.deleteAll()).then {
                mockDBLevels.clear()
            }

            Mockito.`when`(mockAPILevelRepository.getLevels()).thenReturn(mockAPILevels)
            Mockito.`when`(mockAPILevelRepository.insertAll(Mockito.anyList())).then {
                mockAPILevels.addAll(it.getArgument(0))
            }
            Mockito.`when`(mockAPILevelRepository.deleteAll()).then {
                mockAPILevels.clear()
            }
            levelService = LevelService(mockAPILevelRepository, mockDBLevelRepository)
        }
    }

    @Test
    fun `get levels from api`() = runBlocking {
        mockDBLevelRepository.deleteAll()
        mockAPILevelRepository.deleteAll()

        mockAPILevels.addAll(listOf(Level.Sample, Level.Sample, Level.Sample))

        val levels = levelService.getLevels()
        assert(levels.size == 3)
    }

    @Test
    fun `get levels from cache`() = runBlocking {
        mockDBLevelRepository.deleteAll()
        mockAPILevelRepository.deleteAll()

        mockDBLevels.addAll(listOf(Level.Sample, Level.Sample, Level.Sample))

        val levels = levelService.getLevels()
        assert(levels.size == 3)
    }
}
