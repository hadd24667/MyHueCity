package com.example.mycity.data

import com.example.mycity.R

object Datasource {

    private val restaurantsCategory = Category(
        name = R.string.restaurants_category,
        icon = R.drawable.restaurant_icon,
        list = listOf(
            Place(
                name = R.string.cung_dinh_title,
                description = R.string.cung_dinh_description,
                address = R.string.cung_dinh_address,
                photo = R.drawable.cung_dinh
            ),
            Place(
                name = R.string.khong_gian_xua_title,
                description = R.string.khong_gian_xua_description,
                address = R.string.khong_gian_xua_address,
                photo = R.drawable.khong_gian_xua
            )
        )
    )

    private val barsCategory = Category(
        name = R.string.bars_category,
        icon = R.drawable.bar_icon,
        list = listOf(
            Place(
                name = R.string.dong_bar_title,
                description = R.string.dong_bar_description,
                address = R.string.dong_bar_address,
                photo = R.drawable.dong_bar
            ),
            Place(
                name = R.string.sophie_club_title,
                description = R.string.sophie_club_description,
                address = R.string.sophie_club_address,
                photo = R.drawable.sophie_club
            )
        )
    )

    private val parksCategory = Category(
        name = R.string.parks_category,
        icon = R.drawable.nature_icon,
        list = listOf(
            Place(
                name = R.string.cong_vien_3_2_title,
                description = R.string.cong_vien_3_2_description,
                address = R.string.cong_vien_3_2_address,
                photo = R.drawable.cong_vien_3_2
            )
        )
    )

    private val attractionsCategory = Category(
        name = R.string.attractions_category,
        icon = R.drawable.attractions_icon,
        list = listOf(
            Place(
                name = R.string.dai_noi_title,
                description = R.string.dai_noi_description,
                address = R.string.dai_noi_address,
                photo = R.drawable.dai_noi
            ),
            Place(
                name = R.string.lang_tu_duc_title,
                description = R.string.lang_tu_duc_description,
                address = R.string.lang_tu_duc_address,
                photo = R.drawable.lang_tu_duc
            ),
            Place(
                name = R.string.chua_huyen_khong_title,
                description = R.string.chua_huyen_khong_description,
                address = R.string.chua_huyen_khong_address,
                photo = R.drawable.chua_huyen_khong
            )
        )
    )

    private val shopsCategory = Category(
        name = R.string.shops_category,
        icon = R.drawable.shops_icon,
        list = listOf(
            Place(
                name = R.string.santino_title,
                description = R.string.santino_description,
                address = R.string.santino_address,
                photo = R.drawable.santino
            ),
            Place(
                name = R.string.yofaso_title,
                description = R.string.yofaso_description,
                address = R.string.yofaso_address,
                photo = R.drawable.yofaso
            )
        )
    )

    val listOfCategories = listOf(restaurantsCategory, barsCategory, parksCategory, shopsCategory, attractionsCategory)
}
