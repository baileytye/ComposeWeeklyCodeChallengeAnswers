package com.vog.composeweeklycodechallenge.week3

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.vog.composeweeklycodechallenge.ui.theme.ComposeWeeklyCodeChallengeTheme
import com.vog.composeweeklycodechallenge.ui.theme.Purple200

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MattMyAnimation(expanded: Boolean = false) {

    var isExpanded by remember { mutableStateOf(expanded) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        color = MaterialTheme.colors.onBackground,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded },
                text = if (isExpanded) "Collapse" else "Expand",
                style = MaterialTheme.typography.body1.copy(
                    color = MaterialTheme.colors.primary
                )
            )
            AnimatedVisibility(visible = isExpanded) {
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    style = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.background
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun Matthew() {
    ComposeWeeklyCodeChallengeTheme {
        MattMyAnimation()
    }
}

@Preview
@Composable
fun MatthewExpanded() {
    ComposeWeeklyCodeChallengeTheme {
        MattMyAnimation(true)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BaileyExpandingCard(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onExpandClick: () -> Unit
) {
    //Add some bounce, just to show animation specs
    val animSpec = remember {
        spring<IntSize>(dampingRatio = Spring.DampingRatioLowBouncy)
    }
    val padding = 8.dp

    Surface(modifier = modifier, shape = MaterialTheme.shapes.medium, elevation = 4.dp) {
        Column(Modifier.padding(padding)) {
            TextButton(onClick = onExpandClick) {
                Text(text = if (expanded) "Collapse" else "Expand")
            }
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(animationSpec = animSpec) + fadeIn(),
                exit = shrinkVertically(animationSpec = animSpec) + fadeOut()
            ) {
                Text(
                    modifier = Modifier.padding(padding),
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Bailey() {
    ComposeWeeklyCodeChallengeTheme() {
        var expanded by remember {
            mutableStateOf(false)
        }
        BaileyExpandingCard(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            expanded = expanded
        ) {
            expanded = !expanded
        }
    }
}

@Composable
fun DivyaContent(msg: String) {
    var expand by remember {
        mutableStateOf(false)
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(all = 5.dp)
            .clickable { expand = !expand } //Bailey Note: Use card param onClick so that the splash is cropped to shape
            .fillMaxWidth(),
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .padding(all = 5.dp)
//                .animateContentSize() //Bailey Note: See note below
        ) {
            Text(
                text = when (isExpanded) {
                    true -> "Expanded"
                    false -> "Collapsed"
                },
                color = Purple200,
                modifier = Modifier.padding(all = 5.dp)
            )
            Surface( //Bailey Note: This surface is a bit redundant, you could just add .animateContentSize() to the surrounding column, and have only one mutable state
                modifier = Modifier
                    .animateContentSize { initialValue, targetValue ->
                        isExpanded = targetValue.height > initialValue.height
                    }
                    .padding(all = 5.dp)
            ) {

                Text(
                    text = msg,
                    maxLines = if (expand) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

//Preview created by Matthew
@Preview
@Composable
fun Divya() {
    ComposeWeeklyCodeChallengeTheme {
        DivyaContent(msg = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
    }
}

@ExperimentalAnimationApi
@Composable
fun HannoContent(modifier: Modifier = Modifier) {

    var isExpanded by remember { mutableStateOf(false) }

// Made the entire card clickable instead of just the column inside the card
    Card(
        shape = MaterialTheme.shapes.medium, elevation = 4.dp,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                isExpanded = !isExpanded
            } //Bailey Note: Use card param onClick so that the splash is cropped to shape
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = when {
                    isExpanded -> {
                        "Collapse"
                    }
                    else -> "Expand"
                },
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2,
            )

            Spacer(modifier = Modifier.height(4.dp))

            AnimatedVisibility(visible = isExpanded) {
                Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce pellentesque porta ipsum, vitae accumsan elit ultricies eget. Donec ullamcorper massa sed mauris laoreet scelerisque. Sed in ultrices libero, sed lobortis tortor. Morbi varius enim turpis, in ultrices lectus fringilla sit amet. Pellentesque lacinia porta felis, quis congue lectus gravida ac. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Integer erat tortor, fermentum nec mattis eu, luctus at tellus. Suspendisse ultrices, ante non scelerisque fringilla, odio justo blandit justo, ac egestas est dolor vel risus. Nulla tristique efficitur imperdiet.")
            }
        }
    }
}

//Preview created by Matthew
@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun Hanno() {
    ComposeWeeklyCodeChallengeTheme {
        HannoContent()
    }
}