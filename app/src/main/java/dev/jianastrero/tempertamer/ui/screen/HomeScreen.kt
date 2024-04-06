package dev.jianastrero.tempertamer.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.jianastrero.tempertamer.R
import dev.jianastrero.tempertamer.ui.component.DayTabs
import dev.jianastrero.tempertamer.ui.component.Header
import dev.jianastrero.tempertamer.ui.component.LevelItem
import dev.jianastrero.tempertamer.ui.theme.Divider
import dev.jianastrero.tempertamer.viewmodel.main.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    val scrollState = rememberLazyListState()
    val levels by viewModel.levels.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchLevels()
    }

    Scaffold(
        topBar = { HomeHeader(scrollState = scrollState) },
        bottomBar = { HomeFooter() },
        modifier = modifier
    ) { contentPadding ->
        LazyColumn(
            state = scrollState,
            contentPadding = contentPadding,
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(
                items = levels,
                key = { _, level -> level.level }
            ) { index, level ->
                Spacer(modifier = Modifier.height(if (index == 0) 32.dp else 40.dp))
                LevelItem(
                    level = level,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item { Spacer(modifier = Modifier.height(40.dp)) }
        }
    }
}

@Composable
private fun HomeHeader(
    scrollState: LazyListState
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
    ) {
        Header(
            progress = 0.03f,
            progressStatus = "Taming temper",
            dailyProgress = 0.8f,
            dayStreak = 0,
            modifier = Modifier.fillMaxWidth()
        )
        DayTabs(
            onTabSelected = { index ->
                scope.launch {
                    scrollState.animateScrollToItem(index)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
private fun HomeFooter() {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
    ) {
        Spacer(
            modifier = Modifier
                .background(Divider)
                .fillMaxWidth()
                .height(1.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(11.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_journey),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Journey",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
