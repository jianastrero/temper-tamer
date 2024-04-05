package dev.jianastrero.tempertamer.domain.response


import dev.jianastrero.tempertamer.domain.entity.Level
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    @SerialName("levels")
    val levels: List<Level>
)
