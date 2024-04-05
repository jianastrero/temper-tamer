package dev.jianastrero.tempertamer.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import dev.jianastrero.tempertamer.ui.screen.HomeScreen
import dev.jianastrero.tempertamer.ui.theme.TemperTamerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemperTamerTheme {
                HomeScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
