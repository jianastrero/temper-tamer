package dev.jianastrero.tempertamer.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.tempertamer.R
import dev.jianastrero.tempertamer.ui.theme.TemperTamerTheme

@Composable
fun ActivityItem(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_lesson_placeholder),
            contentDescription = null,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 10.dp)
        )
        Text(
            text = "Activity title",
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 20.sp
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun LessonItemPreview() {
    TemperTamerTheme(modifier = Modifier.fillMaxSize()) {
        FlowRow(
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            ActivityItem()
            ActivityItem()
            ActivityItem()
        }
    }
}
