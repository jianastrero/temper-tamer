package dev.jianastrero.tempertamer.domain.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Level(
    @PrimaryKey
    val title: String
)
