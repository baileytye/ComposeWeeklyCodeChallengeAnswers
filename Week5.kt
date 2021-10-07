package com.vog.composeweeklycodechallenge.week5

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vog.composeweeklycodechallenge.ui.theme.ComposeWeeklyCodeChallengeTheme

@Composable
fun BaileyWeek5() {
    val strokeWidth = with(LocalDensity.current) {
        4.dp.toPx()
    }
    val sweepAngle = 90f

    Canvas(
        modifier = Modifier
            .size(120.dp)
            .padding(4.dp), onDraw = {
            drawArc(
                color = Color.Red,
                startAngle = 0f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth)
            )
            drawArc(
                color = Color.Yellow,
                startAngle = 90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth)
            )
            drawArc(
                color = Color.Green,
                startAngle = 180f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth)
            )
            drawArc(
                color = Color.Blue,
                startAngle = 270f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun BaileyWeek5Preview() {
    ComposeWeeklyCodeChallengeTheme {
        BaileyWeek5()
    }
}

@Composable
private fun DivyaCanvasCompose() {
    val radius = 200f
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawArc(
            color = Color.Red,
            startAngle = 0f,
            sweepAngle = 90f,
            useCenter = false,
            topLeft = Offset(size.width / 4, size.height / 4),
            size = Size(radius * 2, radius * 2),
            style = Stroke(20.0f)
        )
        drawArc(
            color =
            Color.Yellow,
            startAngle = 90f,
            sweepAngle = 90f,
            useCenter = false,
            topLeft = Offset(size.width / 4, size.height / 4),
            size = Size(radius * 2, radius * 2),
            style = Stroke(20.0f)
        )
        drawArc(
            color =
            Color.Green,
            startAngle = 180f,
            sweepAngle = 90f,
            useCenter = false,
            topLeft = Offset(size.width / 4, size.height / 4),
            size = Size(radius * 2, radius * 2),
            style = Stroke(20.0f)
        )
        drawArc(
            color =
            Color.Blue,
            startAngle = 270f,
            sweepAngle = 90f,
            useCenter = false,
            topLeft = Offset(size.width / 4, size.height / 4),
            size = Size(radius * 2, radius * 2),
            style = Stroke(20.0f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DivyaWeek5() {
    ComposeWeeklyCodeChallengeTheme {
        DivyaCanvasCompose()
    }
}

@Composable
private fun Hanno() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawCircle(
            style =
            Stroke(width = 10.0f),
            brush = Brush.sweepGradient(
                0.25f to Color.Red,
                0.0f to Color.Yellow,
                0.75f to Color.Green,
                0.0f to Color.Blue,
            ),
            center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
            radius = size.minDimension / 4
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HannoWeek5() {
    ComposeWeeklyCodeChallengeTheme {
        Hanno()
    }
}