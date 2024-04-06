package dev.jianastrero.tempertamer.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.jianastrero.tempertamer.domain.model.screen.Screen
import dev.jianastrero.tempertamer.ui.navgraph.mainNavGraph
import dev.jianastrero.tempertamer.ui.theme.TemperTamerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            TemperTamerTheme(modifier = Modifier.fillMaxSize()) {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) { mainNavGraph(navController) }
            }
        }
    }
}
