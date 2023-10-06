package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.Place
import com.example.mycity.ui.theme.Shapes


@Composable
fun PickAPlaceScreen() {

}

@Composable
fun PlaceCard(place: Place, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = place.photo), contentDescription = null,
            contentScale= ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .clip(shape = Shapes.small)
        )
        Text(text = stringResource(id = place.name))
    }

}

@Preview
@Composable
fun PlaceCardPreview() {
    PlaceCard(
        place = Place(
            name = R.string.kavkaz_title,
            description = R.string.kavkaz_description,
            address = R.string.kavkaz_address,
            photo = R.drawable.kavkaz
        )
    )

}