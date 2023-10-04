package com.example.mycity.ui

import com.example.mycity.R
import com.example.mycity.data.Category
import com.example.mycity.data.Place

data class MyCityUiState(
    val categories: List<Category> = emptyList(),
    val currentCategory: Category = Category(
        name = R.string.restaurants_category,
        icon = R.drawable.restaurant_icon,
        list = emptyList()
    ),
    val currentPlace: Place = Place(
        name = R.string.kavkaz_title,
        description = R.string.kavkaz_description,
        address = R.string.kavkaz_address,
        photo = R.drawable.kavkaz
    )
)