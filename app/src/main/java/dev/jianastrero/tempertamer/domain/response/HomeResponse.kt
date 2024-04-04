package dev.jianastrero.tempertamer.domain.response

import dev.jianastrero.tempertamer.domain.entity.Level

data class HomeResponse(
    val levels: List<Level>
)
