package dev.jianastrero.tempertamer.ui.navgraph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.jianastrero.tempertamer.domain.model.screen.Screen
import dev.jianastrero.tempertamer.ui.screen.HomeScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    composable(Screen.Home.route) {
        HomeScreen(modifier = Modifier.fillMaxSize())
    }
}
