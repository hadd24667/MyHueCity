package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.Category
import com.example.mycity.data.Datasource
import com.example.mycity.data.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState

    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        _uiState.value = MyCityUiState(
            categories = Datasource.listOfCategories
        )
    }

    fun updateCurrentCategory(category: Category) {
        _uiState.update {
            it.copy(
                currentCategory = category
            )
        }
    }


    fun updateCurrentPlace(place: Place) {
        _uiState.update {
            it.copy(
                currentPlace = place
            )
        }
    }

    fun getNextPlace(): Place {
        val placesList = _uiState.value.currentCategory.list
        val currentIndex = placesList.indexOf(_uiState.value.currentPlace)
        if (currentIndex < placesList.size - 1) {
            return placesList[currentIndex + 1]
        } else {
            return placesList[0]
        }
    }
}