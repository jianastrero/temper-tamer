package dev.jianastrero.tempertamer.domain.screen

sealed class Screen(val route: String) {
    data object Home : Screen("home")
}
