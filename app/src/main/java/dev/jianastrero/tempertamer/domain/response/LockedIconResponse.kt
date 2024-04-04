package dev.jianastrero.tempertamer.domain.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LockedIconResponse(
    @SerialName("description")
    val description: String,
    @SerialName("file")
    val `file`: FileResponse,
    @SerialName("title")
    val title: String
)
