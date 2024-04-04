package dev.jianastrero.tempertamer.domain.entity

import androidx.room.Entity

@Entity
data class File(
    val contentType: String,
    val details: Details,
    val fileName: String,
    val url: String
)
