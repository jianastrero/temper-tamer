package dev.jianastrero.tempertamer.domain.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileResponse(
    @SerialName("contentType")
    val contentType: String,
    @SerialName("details")
    val details: DetailsResponse,
    @SerialName("fileName")
    val fileName: String,
    @SerialName("url")
    val url: String
)
