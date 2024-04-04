package dev.jianastrero.tempertamer.domain.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailsResponse(
    @SerialName("size")
    val size: Int
)
