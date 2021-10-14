package com.vog.composeweeklycodechallenge.week6

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vog.composeweeklycodechallenge.ui.theme.ComposeWeeklyCodeChallengeTheme

@Composable
fun BaileyWeek6() {
    val strokeWidth = with(LocalDensity.current) { 4.dp.toPx() }
    val sweepAngle = 90f
    val animationDuration = 1500
    val startSize = 150.dp

    val animation = rememberInfiniteTransition()

    val rotation by animation.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(
                durationMillis = animationDuration,
            ),
        )
    )

    val sizePercent by animation.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(
                durationMillis = animationDuration,
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(
        modifier = Modifier
            .size(startSize)
            .padding(4.dp),
        onDraw = {
            val adjustedWidth = strokeWidth * (1 / sizePercent)

            withTransform({
                scale(sizePercent)
                rotate(rotation)
            }) {
                drawArc(
                    color = Color.Red,
                    startAngle = 0f,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = adjustedWidth)
                )
                drawArc(
                    color = Color.Yellow,
                    startAngle = 90f,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = adjustedWidth)
                )
                drawArc(
                    color = Color.Green,
                    startAngle = 180f,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = adjustedWidth)
                )
                drawArc(
                    color = Color.Blue,
                    startAngle = 270f,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = adjustedWidth)
                )
            }
        })
}

@Preview
@Composable
fun BaileyWeek6Preview() {
    ComposeWeeklyCodeChallengeTheme {
        BaileyWeek6()
    }
}

@Composable
fun HannoWeek6() {
    val strokeWidth = with(LocalDensity.current) { 4.dp.toPx() }
    val sweepAngle = 90f
    val animationDuration = 1500
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(
                animationDuration,
                easing = FastOutSlowInEasing
            )
        )
    )
    val size by infiniteTransition.animateFloat(
        initialValue = 120F,
        targetValue = 60F,
        animationSpec = infiniteRepeatable(
            repeatMode = RepeatMode.Reverse,
            animation = tween(animationDuration)
        )
    )
    Canvas(modifier = Modifier
        .rotate(rotation)
        .size(size.dp)
        .padding(4.dp), onDraw = {
        drawArc(
            color = Color.Red,
            startAngle = 0f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = strokeWidth)
        )
        drawArc(
            color =
            Color.Yellow,
            startAngle = 90f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = strokeWidth)
        )
        drawArc(
            color =
            Color.Green,
            startAngle = 180f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = strokeWidth)
        )
        drawArc(
            color =
            Color.Blue,
            startAngle = 270f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = strokeWidth)
        )
    })
}

@Preview
@Composable
fun HannoWeek6Preview() {
    ComposeWeeklyCodeChallengeTheme {
        HannoWeek6()
    }
}

@Composable
fun DivyaWeek6() {
    val size = 200.dp
    val infiniteAngleTransition = rememberInfiniteTransition()
    val infiniteScaleTransition = rememberInfiniteTransition()
    val angle by infiniteAngleTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing)
        )
    )
    val scale by infiniteScaleTransition.animateFloat(
        initialValue = 1F,
        targetValue = .5F,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(
        modifier = Modifier
            .size(size)
            .scale(scale)
            .padding(8.dp)
            .rotate(angle)
    ) {
        drawArc(
            color = Color.Red,
            startAngle = 0f,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(20.0f)
        )
        drawArc(
            color = Color.Yellow,
            startAngle = 90f,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(20.0f)
        )
        drawArc(
            color = Color.Green,
            startAngle = 180f,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(20.0f)
        )
        drawArc(
            color = Color.Blue,
            startAngle = 270f,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(20.0f)
        )
    }
}

@Preview
@Composable
fun DivyaWeek6Preview() {
    ComposeWeeklyCodeChallengeTheme {
        DivyaWeek6()
    }
}