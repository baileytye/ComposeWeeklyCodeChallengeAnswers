package com.vog.composeweeklycodechallenge.week2

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Week2(modifier: Modifier = Modifier) {
    val padding = 16.dp

    Card(
        modifier = modifier.height(IntrinsicSize.Min),
        elevation = 4.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(padding),
                text = annotatedText(),
                style = MaterialTheme.typography.h6
            )

            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp),
                color = MaterialTheme.colors.onSurface
            )

            Icon(
                modifier = Modifier.padding(padding),
                imageVector = Icons.Outlined.Check,
                contentDescription = null,
                tint = MaterialTheme.colors.secondary
            )
        }
    }
}

@Composable
fun annotatedText() = buildAnnotatedString {
    withStyle(
        SpanStyle(
            color = MaterialTheme.colors.primary,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
    ) {
        append("Jetpack ")
    }
    append("Compose")
}

@Preview(showBackground = true)
@Composable
fun Week2Preview() {
    ComposeWeek2Theme() {
        Week2(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun HannoDrawCard(modifier: Modifier = Modifier) {
    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp,
        modifier = modifier.padding(16.dp)
    ) {
        Row(modifier = modifier.height(IntrinsicSize.Min)) {
            Text(
                modifier = modifier.padding(16.dp),
                style = MaterialTheme.typography.h6,
                text = buildAnnotatedString {
                    withStyle(style = ParagraphStyle(textAlign = TextAlign.Start)) {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colors.primary,
                                fontStyle = FontStyle.Italic
                            )
                        ) { append("Jetpack ") }
                        append("Compose")
                    }
                })
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Icon(
                Icons.Rounded.Check,
                contentDescription = "Localized description",
                modifier = modifier.padding(16.dp),
                tint = MaterialTheme.colors.secondary
            )
        }
    }
}

@Composable
fun GustavoMainCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            GustavoJetPackTitle(
                Modifier
                    .weight(1f)
                    .padding(16.dp)
            )
            Divider(
                color =
                Color.Black, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Icon(
                imageVector = Icons.Filled.Check,
//                painterResource(id = R.drawable.ic_check), //Bailey Changed this to Icons.Filled.Check so I don't need to add resource
                contentDescription = "Check icon",
                tint = Orange,
                modifier = Modifier.padding(end = 16.dp, start = 32.dp)
            )
        }
    }
}

@Composable
fun GustavoJetPackTitle(modifier: Modifier) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Orange,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic
                )
            ) {
                append("Jetpack ")
            }
            withStyle(
                style = SpanStyle(fontWeight = FontWeight.Bold)
            ) {
                append("Compose")
            }
        },
        modifier = modifier,
        fontSize = 14.sp
    )
}

@Composable
fun DivyaComposeChallange2() {
    Column(modifier = Modifier.padding(5.dp)) {
        Card(
            elevation = 2.dp,
            shape = MaterialTheme.shapes.medium
        ) {
            Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Red,
                                fontStyle = FontStyle.Italic,
                                fontWeight = FontWeight.Bold
                            )
                        ) { append("Jetpack") }
                        append(" Compose")
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                        .wrapContentWidth(Alignment.Start)
                )
                Divider(
                    color =
                    Color.Black, modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
                Column(
                    modifier = Modifier
                        .weight(.3f)
                        .align(Alignment.CenterVertically)
                ) {
                    Checkbox(
                        checked = true,
                        onCheckedChange = { },
                        enabled = true,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        colors = CheckboxDefaults.colors(
                            checkedColor = MaterialTheme.colors.background,
                            checkmarkColor = Color.Green,
                            uncheckedColor = MaterialTheme.colors.background
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Gustavo() {
    ComposeWeek2Theme {
        GustavoMainCard()
    }
}

@Preview(showBackground = true)
@Composable
fun Hanno() {
    ComposeWeek2Theme {
        HannoDrawCard()
    }
}

@Preview(showBackground = true)
@Composable
fun Divya() {
    ComposeWeek2Theme {
        DivyaComposeChallange2()
    }
}