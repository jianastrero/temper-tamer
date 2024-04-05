package dev.jianastrero.tempertamer.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Details(
    @SerialName("size")
    val size: Int
) {
    companion object {
        val Sample = Details(
            size = 5998
        )
    }
}
