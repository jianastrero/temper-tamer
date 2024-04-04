package dev.jianastrero.tempertamer.domain.entity

import androidx.room.Entity

@Entity
data class Level(
    val activities: List<Activity>,
    val description: String,
    val level: String,
    val state: String,
    val title: String
)
