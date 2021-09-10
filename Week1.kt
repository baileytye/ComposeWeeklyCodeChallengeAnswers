
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun DiagonalSquares(modifier: Modifier = Modifier) {
    val padding = 16.dp
    val boxMod = Modifier
        .fillMaxWidth(1f.div(3))
        .aspectRatio(1f)

    Column(
        modifier = modifier
            .padding(padding)
            .fillMaxWidth()
    ) {
        Box(
            modifier = boxMod
                .align(Alignment.End)
                .background(color = Color.Red)
        )
        Box(
            modifier = boxMod
                .align(Alignment.CenterHorizontally)
                .background(color = Color.Blue)
        )
        Box(
            modifier = boxMod
                .align(Alignment.Start)
                .background(color = Color.Green)
        )
    }
}

@Composable
fun CanvasDiagonalSquares(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .aspectRatio(1f)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val boxSize = size.div(3f)

        drawRect(
            color = Color.Red,
            size = boxSize,
            topLeft = Offset((canvasWidth / 3 * 2), 0f)
        )

        drawRect(
            color = Color.Blue,
            size = boxSize,
            topLeft = Offset((canvasWidth / 3), (canvasHeight / 3))
        )

        drawRect(
            color = Color.Green,
            size = boxSize,
            topLeft = Offset(0f, (canvasHeight / 3 * 2))
        )
    }
}

@Preview(showBackground = true, widthDp = 640, heightDp = 300)
@Composable
fun DiagonalSquaresPreview() {
    DiagonalSquares(
        modifier = Modifier
            .size(600.dp)
            .verticalScroll(rememberScrollState())
    )
}

@Preview(showBackground = true, widthDp = 640, heightDp = 300)
@Composable
fun CanvasDiagonalSquaresPreview() {
    CanvasDiagonalSquares(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun Gustavo() {
    Row(
        Modifier
            .background(Color.White)
            .padding(16.dp)
            .height(300.dp)
            .wrapContentWidth()
    ) {
        Box(
            Modifier
                .background(Color.Green)
                .height(100.dp)
                .width(100.dp)
                .align(Alignment.Bottom)
                .weight(1f)
        )
        Box(
            Modifier
                .background(Color.Blue)
                .height(100.dp)
                .width(100.dp)
                .align(Alignment.CenterVertically)
                .weight(1f)
        )
        Box(
            Modifier
                .background(Color.Red)
                .height(100.dp)
                .width(100.dp)
                .align(Alignment.Top)
                .weight(1f)
        )
    }
}

@Composable
fun Divya() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.LightGray),

        ) {
        val (container, redBox, centerBlueBox, greenBox) = createRefs()
        ConstraintLayout(modifier = Modifier
            .constrainAs(container) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .size(Dp.Unspecified)
            .background(Color.White)
            .padding(5.dp)

        ) {


            Surface(
                modifier = Modifier
                    .size(60.dp)
                    .constrainAs(redBox) {
                        start.linkTo(centerBlueBox.end)
                        bottom.linkTo(centerBlueBox.top)
                    },
                color = Color.Red
            ) {

            }
            Surface(
                modifier = Modifier
                    .size(60.dp)
                    .constrainAs(centerBlueBox) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    },
                color = Color.Blue
            ) {

            }
            Surface(
                modifier = Modifier
                    .size(60.dp)
                    .constrainAs(greenBox) {
                        end.linkTo(centerBlueBox.start)
                        top.linkTo(centerBlueBox.bottom)
                    },
                color = Color.Green
            ) {

            }
        }

    }
}

@Composable
fun Hanno() {
    Column(Modifier.padding(16.dp)) {
        HannoDrawSingleRowWithABox(Arrangement.End, Color.Red)
        HannoDrawSingleRowWithABox(Arrangement.Center, Color.Blue)
        HannoDrawSingleRowWithABox(Arrangement.Start, Color.Green)
    }
}

@Composable
fun HannoDrawSingleRowWithABox(boxPosition: Arrangement.Horizontal, boxColor: Color) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .width(300.dp),
        boxPosition
    ) {
        HannoDrawSingleBox(boxColor)
    }
}

@Composable
fun HannoDrawSingleBox(color: Color) {
    Box(
        modifier = Modifier
            .background(color)
            .width(100.dp)
            .height(100.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun HannoPreview() {
    Hanno()
}

@Preview
@Composable
fun GustavoPreview() {
    Gustavo()
}

@Preview
@Composable
fun DivyaPreview() {
    Divya()
}


