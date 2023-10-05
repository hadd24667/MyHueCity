package com.example.mycity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.MyCityViewModel
import com.example.mycity.ui.PickACategoryScreen


enum class MyCityScreen(val title: Int) {
    Start(title = 0)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val viewModel: MyCityViewModel = viewModel()

    Scaffold(topBar = {
        MyCityAppBar(canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })
    }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(navController = navController, startDestination = MyCityScreen.Start.name) {
            composable(
                route = MyCityScreen.Start.name
            ) {
                PickACategoryScreen(
                    uiState = viewModel.uiState,
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
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    TopAppBar(title = {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(text = stringResource(id = R.string.app_name), modifier = Modifier)
            Image(
                painter = painterResource(id = R.drawable.emblem_of_yerevan),
                contentDescription = null
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