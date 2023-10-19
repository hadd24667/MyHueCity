package com.example.mycity.ui

import com.example.mycity.R
import com.example.mycity.data.Category
import com.example.mycity.data.Datasource
import com.example.mycity.data.Place

data class MyCityUiState(
    val categories: List<Category> = Datasource.listOfCategories,
    val currentCategory: Category = Category(
        name = R.string.restaurants_category,
        icon = R.drawable.restaurant_icon,
        list = Datasource.restaurantsCategory.list
    ),
    val currentPlace: Place? = null
)