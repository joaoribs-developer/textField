package com.quality.weboil.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AnoVeiculoViewModel: ViewModel() {

    val maxChar: Int = 1

    private var _firstField by mutableStateOf("")
    val firstField: String get() = _firstField

    fun onChangeFirstField(value: String) {
        _firstField = value
    }
    private var _secondField by mutableStateOf("")
    val secondField: String get() = _secondField

    fun onChangeSecondField(value: String) {
        _secondField = value
    }
    private var _thirdField by mutableStateOf("")
    val thirdField: String get() = _thirdField

    fun onChangeThirdField(value: String) {
        _thirdField = value
    }
    private var _fourthField by mutableStateOf("")
    val fourthField: String get() = _fourthField

    fun onChangeFourthField(value: String) {
        _fourthField = value
    }
}