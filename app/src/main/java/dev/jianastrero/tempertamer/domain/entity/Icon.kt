package dev.jianastrero.tempertamer.domain.entity

import androidx.room.Entity

@Entity
data class Icon(
    val description: String,
    val `file`: File,
    val title: String
)
