import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun BaileyWeek8() {
    val offset = remember {
        Animatable(Offset(0f, 0f), Offset.VectorConverter)
    }

    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            Modifier
                .size(50.dp)
                .align(Alignment.Center)
                .offset {
                    IntOffset(offset.value.x.roundToInt(), offset.value.y.roundToInt())
                }
                .background(Color.Blue)
                .pointerInput(Unit) {
                    detectDragGestures(onDrag = { change, dragAmount ->
                        change.consumeAllChanges()
                        coroutineScope.launch {
                            offset.snapTo(dragAmount + offset.value)
                        }
                    }, onDragEnd = {
                        coroutineScope.launch {
                            offset.animateTo(Offset(0f, 0f))
                        }
                    })
                }
        )
    }
}

private fun Offset.toIntOffset() = IntOffset(x.roundToInt(), y.roundToInt())

@Composable
fun DivyaWeek8() {
    Box(modifier = Modifier.fillMaxSize()) {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        var dragState by remember { mutableStateOf(DragState.Start) }
        val transition = updateTransition(dragState, label = "dragState")
        val animateOffsetX by transition.animateFloat(transitionSpec = {
            tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing
            )
        }, label = "animateOffsetX") {
            when (it) {
                DragState.End -> 0f
                else -> offsetX
            }
        }
        val animateOffsetY by transition.animateFloat(transitionSpec = {
            tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing
            )
        }, label = "animateOffsetY") {
            Log.e("Hgh", "${transition.isRunning}")
            when (it) {
                DragState.End -> 0f
                else -> offsetY
            }
        }
        Box(Modifier
            .offset {
                when (dragState) {
                    DragState.Start -> {
                        IntOffset(offsetX.roundToInt(), offsetY.roundToInt())
                    }
                    DragState.End -> {
                        IntOffset(animateOffsetX.roundToInt(), animateOffsetY.roundToInt())
                    }
                }
            }
            .background(Color.Blue)
            .align(Alignment.Center)
            .size(50.dp)
            .pointerInput(Unit) {
                detectDragGestures(onDragEnd = {
                    dragState = DragState.End
                    offsetX = 0f
                    offsetY = 0f
                }) { change, dragAmount ->
                    dragState =
                        DragState.Start
                    change.consumeAllChanges()
                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                }
            })
    }
}

enum class DragState { Start, End }

@Composable
fun HannoWeek8() {
    Box(modifier = Modifier.fillMaxSize()) {
        val originalX = 0f
        val originalY = 0f
        var offsetX by remember { mutableStateOf(originalX) }
        var offsetY by remember { mutableStateOf(originalY) }
        Box(
            Modifier
                .align(Alignment.Center)
                .offset {
                    IntOffset(
                        offsetX.roundToInt(),
                        offsetY.roundToInt()
                    )
                }
                .background(Color.Blue)
                .size(50.dp)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragEnd = {
                            offsetX = originalX
                            offsetY = originalY
                        },
                        onDrag = { change, dragAmount ->
                            change.consumeAllChanges()
                            offsetX += dragAmount.x
                            offsetY += dragAmount.y
                        })
                })
    }
}

@Composable
fun GustavoWeek8() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val offset = remember {
            Animatable(
                Offset(0f, 0f),
                Offset.VectorConverter
            )
        }
        Box(
            Modifier
                .offset { offset.value.toIntOffset() }
                .background(Color.Blue)
                .size(50.dp)
                .align(Alignment.Center)
                .pointerInput(Unit) {
                    coroutineScope {
                        var currentX = 0f
                        var currentY = 0f
                        detectDragGestures(onDragEnd = {
                            currentX = 0f
                            currentY = 0f
                            launch {
                                offset.animateTo(
                                    Offset(
                                        currentX,
                                        currentY
                                    )
                                )
                            }
                        }) { change, dragAmount ->
                            change.consumeAllChanges()
                            currentX += dragAmount.x
                            currentY += dragAmount.y
                            launch {
                                offset.snapTo(
                                    Offset(currentX, currentY)
                                )
                            }
                        }
                    }
                })
    }
}