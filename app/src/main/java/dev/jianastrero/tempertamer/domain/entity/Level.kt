package dev.jianastrero.tempertamer.domain.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.jianastrero.tempertamer.domain.enumeration.LevelState
import dev.jianastrero.tempertamer.domain.model.Activity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Level(
    @SerialName("activities")
    val activities: List<Activity>,
    @SerialName("description")
    val description: String,
    @SerialName("level")
    val level: String,
    @SerialName("state")
    val state: LevelState,
    @PrimaryKey
    @SerialName("title")
    val title: String
) {
    companion object {
        val Sample = Level(
            activities = listOf(Activity.Sample, Activity.Sample, Activity.Sample),
            description = "Collect your personalised techniques to beat Anxiety",
            level = "1",
            state = LevelState.AVAILABLE,
            title = "Find your tools"
        )
    }
}

