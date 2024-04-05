package dev.jianastrero.tempertamer.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.jianastrero.tempertamer.viewmodel.main.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.fetchLevels()
    }

    Column(modifier = modifier) {
        Text(text = "Temper Tamer")
    }
}
