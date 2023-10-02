package com.example.mycity.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.R

@Composable
fun PickACategoryScreen(){

}

@Composable
fun CategoryCard(numberOfItems: Int, modifier: Modifier = Modifier) {
    Card {
        Row {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.restaurant_icon),
                contentDescription = null
            )
            Text(text = "Restaurants")
        }
        Text(text = "6")
    }

}

@Preview
@Composable
fun CategoryCardPreview() {
    CategoryCard(6)

}