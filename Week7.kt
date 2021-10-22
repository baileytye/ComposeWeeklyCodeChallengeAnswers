package com.vog.composeweeklycodechallenge.week7

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vog.composeweeklycodechallenge.ui.theme.ComposeWeeklyCodeChallengeTheme

@Composable
fun BaileyWeek7() {
    val strokeWidth = with(LocalDensity.current) {
        4.dp.toPx()
    }
    val sweepAngle = 90f
    val animationDuration = 1500
    val startSize = 150.dp

    val animation = rememberInfiniteTransition()

    val gap by animation.animateFloat(
        initialValue = 80f,
        targetValue = 0f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(durationMillis = animationDuration),
            repeatMode = RepeatMode.Reverse
        )
    )

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
        initialValue = 0.5f, targetValue = 1f, animationSpec = InfiniteRepeatableSpec(
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
                    startAngle = 0f + gap,
                    sweepAngle = sweepAngle - gap,
                    useCenter = false,
                    style = Stroke(width = adjustedWidth, cap = StrokeCap.Round)
                )
                drawArc(
                    color = Color.Yellow,
                    startAngle = 90f + gap,
                    sweepAngle = sweepAngle - gap,
                    useCenter = false,
                    style = Stroke(width = adjustedWidth, cap = StrokeCap.Round)
                )
                drawArc(
                    color = Color.Green,
                    startAngle = 180f + gap,
                    sweepAngle = sweepAngle - gap,
                    useCenter = false,
                    style = Stroke(width = adjustedWidth, cap = StrokeCap.Round)
                )
                drawArc(
                    color = Color.Blue,
                    startAngle = 270f + gap,
                    sweepAngle = sweepAngle - gap,
                    useCenter = false,
                    style = Stroke(width = adjustedWidth, cap = StrokeCap.Round)
                )
            }
        })
}

@Preview
@Composable
fun BaileyWeek7Preview() {
    ComposeWeeklyCodeChallengeTheme {
        Column {
            BaileyWeek7()
            HannoWeek7()
            DivyaWeek7()
        }
    }
}

@Composable
fun DivyaWeek7() {
    val size = 200.dp
    val strokeWidth = with(LocalDensity.current) { 8.dp.toPx() }
    val infiniteAngleTransition = rememberInfiniteTransition()
    val infiniteScaleTransition = rememberInfiniteTransition()
    val angle by infiniteAngleTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(animation = tween(1500, easing = FastOutSlowInEasing))
    )
    val scale by infiniteScaleTransition.animateFloat(
        initialValue = 1F,
        targetValue = .5F,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val sweepAngle by infiniteAngleTransition.animateFloat(
        initialValue = 90F,
        targetValue = 10F,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(
        modifier = Modifier
            .size(size)
            .padding(8.dp)
    ) {
        withTransform({
            scale(scale)
            rotate(angle)
        }) {
            drawArc(
                color = Color.Red,
                startAngle = 0f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Round),
            )
            drawArc(
                color =
                Color.Yellow,
                startAngle = 90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )
            drawArc(
                color =
                Color.Green,
                startAngle = 180f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )
            drawArc(
                color =
                Color.Blue,
                startAngle = 270f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )
        }
    }
}

@Preview
@Composable
fun DivyaWeek7Preview() {
    ComposeWeeklyCodeChallengeTheme {
        DivyaWeek7()
    }
}

@Composable
fun HannoWeek7() {
    val strokeWidth = with(LocalDensity.current) { 4.dp.toPx() }
    val animationDuration = 1500
    val startSize = 150.dp
    val animation = rememberInfiniteTransition()
    val rotation by animation.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = InfiniteRepeatableSpec(animation = tween(durationMillis = animationDuration))
    )
    val sizePercent by animation.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(durationMillis = animationDuration),
            repeatMode = RepeatMode.Reverse
        )
    )
    val sweepAngle by animation.animateFloat(
        initialValue = 10f,
        targetValue = 90f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(durationMillis = animationDuration),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(modifier = Modifier
        .size(startSize)
        .padding(4.dp),
        onDraw = {
            val adjustedWidth =
                strokeWidth * (1 / sizePercent)
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
                    color =
                    Color.Yellow,
                    startAngle = 90f,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = adjustedWidth)
                )
                drawArc(
                    color =
                    Color.Green,
                    startAngle = 180f,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = adjustedWidth)
                )
                drawArc(
                    color =
                    Color.Blue,
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
fun HannoWeek7Preview() {
    ComposeWeeklyCodeChallengeTheme {
        HannoWeek7()
    }
}