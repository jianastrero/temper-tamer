package dev.jianastrero.tempertamer.domain.model


import androidx.room.Embedded
import dev.jianastrero.tempertamer.domain.enumeration.ActivityState
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
    val state: ActivityState,
    @SerialName("title")
    val title: String,
    @SerialName("titleB")
    val titleB: String?,
    @SerialName("type")
    val type: String
) {
    companion object {
        val Sample = Activity(
            challengeId = "2ECefjj9gotSu1RzQYguQV",
            description = "When feeling anxious we tend to worry on repeat. And the more we worry, the more we feel anxious. It’s a vicious cycle. Let’s learn how to break out of it early.",
            descriptionB = null,
            icon = Icon.Sample,
            id = "2ECefjj9gotSu1RzQYguQV7FBMJel296NaotMcf3PwJ432uh72",
            lockedIcon = Icon.Sample,
            state = ActivityState.NOT_SET,
            title = "Break your worry chain reaction",
            titleB = null,
            type = "PRACTICE"
        )
    }
}

fun Activity.iconUrl(isLocked: Boolean) = if (isLocked) lockedIcon.file.url else icon.file.url

fun Activity.iconFilename(isLocked: Boolean) =
    if (isLocked) lockedIcon.file.fileName
    else icon.file.fileName
