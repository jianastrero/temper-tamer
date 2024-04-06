package dev.jianastrero.tempertamer.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.tempertamer.R
import dev.jianastrero.tempertamer.ui.theme.TemperTamerTheme

@Composable
fun Header(
    progress: Float,
    progressStatus: String,
    dayStreak: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_app_icon),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        ProgressHeader(
            progress = progress,
            progressStatus = progressStatus,
            modifier = Modifier.padding(start = 12.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        StreakHeader(
            dayStreak = dayStreak
        )
        UserIconHeader(
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
private fun ProgressHeader(
    progress: Float,
    progressStatus: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier
    ) {
        Text(
            text = progressStatus,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 18.sp
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .size(72.dp, 4.dp)
                    .clip(shape = RoundedCornerShape(50))
            )
            Text(
                text = "%.0f%%".format(progress * 100),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 10.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 15.sp
            )
        }
    }
}

@Composable
private fun StreakHeader(
    dayStreak: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_fire),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "$dayStreak",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 26.sp
        )
    }
}

@Composable
private fun UserIconHeader(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .shadow(elevation = 4.dp, shape = CircleShape)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = CircleShape
            )
            .let {
                if (isSystemInDarkTheme()) it.border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = CircleShape
                ) else it
            }
            .size(40.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(10.12.dp, 17.77.dp)
        )
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    TemperTamerTheme(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Header(
                progress = 0.03f,
                progressStatus = "Taming Temper",
                dayStreak = 0,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
