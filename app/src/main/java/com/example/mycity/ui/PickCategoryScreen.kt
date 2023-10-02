package com.example.mycity.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun PickACategoryScreen(uiState: MyCityUiState) {
    LazyColumn() {

    }

}

@Composable
fun CategoryCard(category: Category, modifier: Modifier = Modifier) {
    Card {
        Row(modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = ImageVector.vectorResource(id = category.icon),
                contentDescription = null,
                modifier = Modifier.padding(end=dimensionResource(id = R.dimen.padding_medium))
            )
            Column {
                Text(text = stringResource(id = category.name))
                Text(text = "Number of ${stringResource(id = category.name).lowercase()}: " + category.list.size.toString())
            }

        }

    }

}

@Preview
@Composable
fun CategoryCardPreview() {
    CategoryCard(Datasource.restaurantsCategory)

}