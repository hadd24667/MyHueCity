package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.mycity.R
import com.example.mycity.ui.theme.Shapes

@Composable
fun PlaceScreen(uiState: MyCityUiState, onClick: () -> Unit, modifier: Modifier = Modifier) {


    ConstraintLayout(modifier = modifier) {
        val (image, card) = createRefs()
        Image(painter = painterResource(id = uiState.currentPlace.photo),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(image) {
                    top.linkTo(parent.top)
                })
        Card(shape = RoundedCornerShape(topEnd = dimensionResource(id = R.dimen.padding_place_card)),
            modifier = Modifier
                .constrainAs(card) {
                    top.linkTo(image.bottom, margin = (-60).dp)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
                .shadow(
                    dimensionResource(id = R.dimen.shadow_elevation),
                    shape = Shapes.large,
                    ambientColor = Color.Cyan
                )) {

            Row(
                modifier = Modifier.padding(
                    end = dimensionResource(id = R.dimen.padding_place_card),
                    bottom = dimensionResource(id = R.dimen.padding_small),
                    top = dimensionResource(id = R.dimen.padding_medium),
                    start = dimensionResource(id = R.dimen.padding_medium)
                )

            ) {
                Text(
                    text = stringResource(id = uiState.currentPlace.name),
                    modifier = Modifier.weight(5f)
                )
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.location_icon),
                    contentDescription = null
                )
                Text(text = stringResource(id = uiState.currentPlace.address))
            }
            Text(
                text = stringResource(id = uiState.currentPlace.description),
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(
                    end = dimensionResource(id = R.dimen.padding_large),
                    start = dimensionResource(id = R.dimen.padding_medium)
                ))
            Spacer(Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { onClick },
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))

                ) {
                    Text(text = "Next")
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
                }
            }



        }
    }

}

@Preview(showBackground = true)
@Composable
fun PlaceScreenPreview() {
    PlaceScreen(uiState = MyCityUiState(), onClick = {}, modifier = Modifier.fillMaxSize())
}