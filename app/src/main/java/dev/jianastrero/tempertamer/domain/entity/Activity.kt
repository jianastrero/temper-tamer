package dev.jianastrero.tempertamer.domain.entity

import androidx.room.Entity

@Entity
data class Activity(
    val challengeId: String,
    val description: String,
    val descriptionB: String?,
    val icon: Icon,
    val id: String,
    val lockedIcon: LockedIcon,
    val state: String,
    val title: String,
    val titleB: String,
    val type: String
)
