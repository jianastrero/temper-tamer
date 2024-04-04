package dev.jianastrero.tempertamer.repository.level

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.jianastrero.tempertamer.domain.entity.Level
import dev.jianastrero.tempertamer.domain.response.HomeResponse
import javax.inject.Inject
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class LevelAPIRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : ILevelRepository {
    @OptIn(ExperimentalSerializationApi::class)
    override fun getLevels(): List<Level> {
        val response = Json.decodeFromStream<HomeResponse>(context.assets.open("home.json"))
        return response.levels
    }
}
