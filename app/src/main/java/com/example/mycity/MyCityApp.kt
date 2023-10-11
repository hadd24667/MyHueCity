package com.example.mycity

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.MyCityViewModel
import com.example.mycity.ui.PickCategoryScreen
import com.example.mycity.ui.PickPlaceScreen
import com.example.mycity.ui.PlaceScreen
import com.example.mycity.ui.theme.MyCityTheme


enum class MyCityScreen {
    Start,
    PlacesList,
    Place

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    navController: NavHostController = rememberNavController(),
    viewModel: MyCityViewModel = viewModel()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.Start.name
    )
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(topBar = {
        MyCityAppBar(
            title= when(currentScreen.name){
                                           MyCityScreen.PlacesList.name -> uiState.currentCategory.name
                                            else->R.string.app_name
                                           }

            ,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() },
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
        )
    }
    ) { innerPadding ->


        NavHost(navController = navController, startDestination = MyCityScreen.Start.name) {
            composable(
                route = MyCityScreen.Start.name
            ) {
                PickCategoryScreen(
                    viewModel = viewModel,
                    navigateFunction = { navController.navigate(MyCityScreen.PlacesList.name) },
                    uiState = uiState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
            composable(
                route = MyCityScreen.PlacesList.name
            ) {
                PickPlaceScreen(
                    navigateFunction = { navController.navigate(MyCityScreen.Place.name) },
                    viewModel = viewModel,
                    uiState = uiState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
            composable(
                route = MyCityScreen.Place.name
            ) {
                PlaceScreen(
                    uiState = uiState,
                    onClick = { TODO() },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int = R.string.app_name,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    TopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.emblem_of_yerevan),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_medium),
                        end = dimensionResource(id = R.dimen.padding_medium)
                    )
            )
            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f)
            )

        }
    },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        })
}

@Preview
@Composable
fun MyAppPreview() {
    MyCityTheme {
        MyCityApp()
    }
}