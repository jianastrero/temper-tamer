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
)
