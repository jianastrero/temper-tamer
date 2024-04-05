package dev.jianastrero.tempertamer.domain.model


import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Activity(
    @SerialName("challengeId")
    val challengeId: String,
    @SerialName("description")
    val description: String,
    @SerialName("descriptionB")
    val descriptionB: String?,
    @Embedded
    @SerialName("icon")
    val icon: Icon,
    @SerialName("id")
    val id: String,
    @Embedded
    @SerialName("lockedIcon")
    val lockedIcon: Icon,
    @SerialName("state")
    val state: String,
    @SerialName("title")
    val title: String,
    @SerialName("titleB")
    val titleB: String?,
    @SerialName("type")
    val type: String
)
