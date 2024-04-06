package dev.jianastrero.tempertamer.domain.model.screen

sealed class Screen(val route: String) {
    data object Home : Screen("home")
}
