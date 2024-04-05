package dev.jianastrero.tempertamer.domain.model

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Icon(
    @SerialName("description")
    val description: String,
    @Embedded
    @SerialName("file")
    val `file`: File,
    @SerialName("title")
    val title: String
) {
    companion object {
        val Sample = Icon(
            description = "",
            file = File.Sample,
            title = "Chapter=01, Lesson=02, State=Active"
        )
    }
}
