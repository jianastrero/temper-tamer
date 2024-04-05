package dev.jianastrero.tempertamer.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.jianastrero.tempertamer.ui.component.DayTabs
import dev.jianastrero.tempertamer.ui.component.Header
import dev.jianastrero.tempertamer.ui.component.LevelItem
import dev.jianastrero.tempertamer.viewmodel.main.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.fetchLevels()
    }

    val levels by viewModel.levels.collectAsState()

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
        LazyColumn(
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            item { Spacer(modifier = Modifier.height(0.dp)) }
            itemsIndexed(
                items = levels,
                key = { _, level -> level.level }
            ) { index, level ->
                if (index != 0) Spacer(modifier = Modifier.height(8.dp))
                LevelItem(
                    level = level,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item { Spacer(modifier = Modifier.height(0.dp)) }
        }
    }
}
