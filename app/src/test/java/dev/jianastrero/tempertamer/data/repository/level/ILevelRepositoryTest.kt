package dev.jianastrero.tempertamer.data.repository.level

import dev.jianastrero.tempertamer.domain.entity.Level
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class ILevelRepositoryTest {

    private val mockLevelRepository = mock<ILevelRepository>()
    private val mockLevels = mutableListOf<Level>()

    @Before
    fun setup() {
        runBlocking {
            Mockito.`when`(mockLevelRepository.getLevels()).thenReturn(mockLevels)
            Mockito.`when`(mockLevelRepository.insertAll(Mockito.anyList())).then {
                mockLevels.addAll(it.getArgument(0))
            }
            Mockito.`when`(mockLevelRepository.deleteAll()).then {
                mockLevels.clear()
            }
        }
    }

    @Test
    fun `test empty`() = runBlocking {
        mockLevelRepository.deleteAll()
        val levels = mockLevelRepository.getLevels()
        assert(levels.isEmpty())
    }

    @Test
    fun `test 3 items`()= runBlocking {
        mockLevelRepository.deleteAll()
        mockLevelRepository.insertAll(listOf(Level.Sample, Level.Sample, Level.Sample))
        val levels = mockLevelRepository.getLevels()
        assert(levels.size == 3)
    }
}
