package com.example.mycity.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun CategoryCard(modifier: Modifier =Modifier) {
    Card {
        Row {
            Icon(imageVector = Icons.Default.Star, contentDescription = null)
            Text(text = "Restaurants")
        }
    }

}

@Preview
@Composable
fun CategoryCardPreview() {
CategoryCard()

}