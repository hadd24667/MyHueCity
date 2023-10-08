package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PlaceScreen(uiState: MyCityUiState, modifier: Modifier = Modifier) {
    Column {

        Image(painter = painterResource(id = uiState.currentPlace.photo), contentDescription = null)
        Text(text = stringResource(id = uiState.currentPlace.name))
        Text(text = stringResource(id = uiState.currentPlace.address))
        Text(text = stringResource(id = uiState.currentPlace.description))
    }
}

@Preview(showBackground = true)
@Composable
fun PlaceScreenPreview() {
    PlaceScreen(uiState = MyCityUiState(), modifier = Modifier.fillMaxSize())
}