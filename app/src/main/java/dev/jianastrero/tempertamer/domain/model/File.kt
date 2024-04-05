package dev.jianastrero.tempertamer.domain.model


import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class File(
    @SerialName("contentType")
    val contentType: String,
    @Embedded
    @SerialName("details")
    val details: Details,
    @SerialName("fileName")
    val fileName: String,
    @SerialName("url")
    val url: String
) {
    companion object {
        val Sample = File(
            contentType = "application/pdf",
            details = Details.Sample,
            fileName = "Chapter_01__Lesson_02__State_Active.pdf",
            url = "//assets.ctfassets.net/37k4ti9zbz4t/DVQrkzmSp53EXqmFn9z1L/f4270b3b29c508c04493ead947e8651f/Chapter_01__Lesson_02__State_Active.pdf"
        )
    }
}
