package com.example.mycity.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.R
import com.example.mycity.data.Category
import com.example.mycity.data.Datasource
import com.example.mycity.ui.theme.Shapes

@Composable
fun PickCategoryScreen(
    viewModel: MyCityViewModel,
    uiState: MyCityUiState,
    navigateFunction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var visible by remember { mutableStateOf(true) }
    var index = 1
    LazyColumn(modifier = modifier.padding(top = dimensionResource(id = R.dimen.padding_medium))) {
        items(uiState.categories) {
            AnimatedVisibility(
                visible = visible,
                exit = slideOutHorizontally(animationSpec = tween(durationMillis = 500 * index)) { full ->
                    -3 * full
                }
            ) {
                CategoryCard(category = it, modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = dimensionResource(
                            id = R.dimen.padding_small
                        ),
                        start = dimensionResource(id = R.dimen.padding_medium),
                        end = dimensionResource(id = R.dimen.padding_medium)
                    ),
                    onClick = {
                        visible = false
                        viewModel.updateCurrentCategory(it)
                        navigateFunction()
                    })
            }
            index++
        }
    }

}

@Composable
fun ExpandedPickCategoryScreen(
    viewModel: MyCityViewModel,
    uiState: MyCityUiState,
    modifier: Modifier = Modifier
) {

    LazyColumn(modifier = modifier.padding(top = dimensionResource(id = R.dimen.padding_medium))) {
        items(uiState.categories) {
            val animatedColor by animateColorAsState(
                if (it.name==uiState.currentCategory.name) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primaryContainer,
                label = "color"
            )
            CategoryCard(category = it, modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = dimensionResource(
                        id = R.dimen.padding_small
                    ),
                    start = dimensionResource(id = R.dimen.padding_medium),
                    end = dimensionResource(id = R.dimen.padding_medium)
                ),
                onClick = {
                    viewModel.updateCurrentCategory(it)
                },
                colors = CardDefaults.cardColors(
                    containerColor = animatedColor
                ))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(
    category: Category, modifier: Modifier = Modifier, onClick: () -> Unit = {}, colors:CardColors=CardDefaults.cardColors()
) {
    Card(
        colors=colors,
        onClick = onClick,
        shape = Shapes.medium,
        modifier = modifier
    ) {
        Row(
            modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = category.icon),
                contentDescription = null,
                modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_medium))
            )
            Column {
                Text(
                    text = stringResource(id = category.name),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Number of ${stringResource(id = category.name).lowercase()}: " + category.list.size.toString(),
                    style = MaterialTheme.typography.labelMedium
                )
            }

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandedCategoryCard( category: Category, modifier: Modifier = Modifier, onClick: () -> Unit = {}, colors:CardColors=CardDefaults.cardColors()){
    Card(
        colors=colors,
        onClick = onClick,
        shape = Shapes.medium,
        modifier = modifier
    ) {
        Row(
            modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = category.icon),
                contentDescription = null,
                modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_medium))
            )
            Column {
                Text(
                    text = stringResource(id = category.name),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Number of ${stringResource(id = category.name).lowercase()}: " + category.list.size.toString(),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "",
                modifier = Modifier.padding(start= dimensionResource(id = R.dimen.padding_medium), end = dimensionResource(
                    id = R.dimen.padding_medium)
                ))

        }

    }
}

@Preview
@Composable
fun CategoryCardPreview() {
    ExpandedCategoryCard(Datasource.restaurantsCategory)

}