package dev.jianastrero.tempertamer.domain.entity

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Details(
    val size: Int
)
