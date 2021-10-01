package com.vog.composeweeklycodechallenge.week4

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vog.composeweeklycodechallenge.ui.theme.ComposeWeeklyCodeChallengeTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BaileyWeek4(modifier: Modifier = Modifier) {
    val padding = 16.dp

    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(padding)) {
        item {
            Text(
                modifier = Modifier.padding(top = padding, start = padding, end = padding),
                text = "The Title",
                style = MaterialTheme.typography.h4
            )
        }

        stickyHeader {
            Surface(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colors.secondary) {
                Text(
                    modifier = Modifier.padding(padding),
                    text = "Stay pinned",
                    style = MaterialTheme.typography.h5
                )
            }
        }

        items(8) {
            Card(
                modifier = Modifier
                    .height(200.dp)
                    .padding(horizontal = padding)
                    .fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Text(modifier = Modifier.padding(padding), text = "Some card content")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BaileyPreview() {
    ComposeWeeklyCodeChallengeTheme {
        BaileyWeek4(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun DivyaComposeChallenge4() {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        item {
            Text(
                text = "The Title",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
                    .padding(start = 16.dp, bottom = 8.dp, top = 8.dp),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h4
            )
        }
        stickyHeader {
            Text(
                text = "Stay pinned",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.secondary)
                    .padding(16.dp),
                color = MaterialTheme.colors.onSecondary,
                style = MaterialTheme.typography.h5
            )
        }
        items(count = 10) {
            Card(
                modifier = Modifier
                    .height(200.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Some card content",
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview(showBackground = true)
fun DivyaWeek4() {
    ComposeWeeklyCodeChallengeTheme() {
        DivyaComposeChallenge4()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HannoDrawList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item {
            Text(
                text = "The Title",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )
        }
        stickyHeader {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(MaterialTheme.colors.secondary)
            ) {
                Text(
                    text = "Stay pinned",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .fillMaxWidth()
                )
            }
        }
        items(6) {
            Card(
                modifier = Modifier
                    .height(200.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.primary
            ) { Text(modifier = Modifier.padding(16.dp), text = "Some card content") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HannoWeek4() {
    ComposeWeeklyCodeChallengeTheme {
        HannoDrawList()
    }
}