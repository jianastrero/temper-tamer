package dev.jianastrero.tempertamer.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.tempertamer.R
import dev.jianastrero.tempertamer.domain.entity.Level
import dev.jianastrero.tempertamer.domain.enumeration.LevelState
import dev.jianastrero.tempertamer.ui.theme.TemperTamerTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LevelItem(
    level: Level,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.ic_level),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = 14.dp)
                        .size(102.dp, 86.dp)
                )
                Text(
                    text = "LEVEL ${level.level}",
                    color = MaterialTheme.colorScheme.background,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .background(
                            color = MaterialTheme.colorScheme.onBackground,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(horizontal = 64.dp)
            ) {
                Text(
                    text = level.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = level.description,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        FlowRow(
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 23.5.dp)
        ) {
            level.activities.forEach { activity ->
                ActivityItem(
                    isLocked = level.state == LevelState.LOCKED,
                    activity = activity,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Preview
@Composable
private fun LevelItemPreview() {
    TemperTamerTheme(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            LevelItem(
                level = Level.Sample,
                modifier = Modifier.fillMaxWidth()
            )
            LevelItem(
                level = Level.Sample.copy(level = "2", state = LevelState.LOCKED),
                modifier = Modifier.fillMaxWidth()
            )
            LevelItem(
                level = Level.Sample.copy(level = "3", state = LevelState.LOCKED),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
