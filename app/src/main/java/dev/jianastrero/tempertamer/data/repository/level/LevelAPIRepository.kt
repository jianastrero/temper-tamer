package dev.jianastrero.tempertamer.data.repository.level

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.jianastrero.tempertamer.domain.entity.Level
import dev.jianastrero.tempertamer.domain.response.HomeResponse
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class LevelAPIRepository @Inject constructor(
    @ApplicationContext private val context: Context
) : ILevelRepository {
    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getLevels(): List<Level> = withContext(Dispatchers.IO) {
        val response = Json.decodeFromStream<HomeResponse>(context.assets.open("home.json"))
        Log.d("JIANDDEBUG", "response: $response")
        response.levels
    }

    override suspend fun insertAll(levels: List<Level>) {
        // Do nothing
    }

    override suspend fun deleteAll() {
        // Do nothing
    }
}
