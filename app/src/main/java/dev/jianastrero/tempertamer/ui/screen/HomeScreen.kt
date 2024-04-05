package dev.jianastrero.tempertamer.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.jianastrero.tempertamer.ui.component.DayTabs
import dev.jianastrero.tempertamer.ui.component.Header
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
        Header(
            progress = 0.03f,
            progressStatus = "Taming temper",
            dailyProgress = 0.8f,
            dayStreak = 0,
            modifier = Modifier.fillMaxWidth()
        )
        DayTabs(
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}
