package com.example.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textfield.ui.theme.TextFieldTheme
import com.quality.weboil.viewmodel.AnoVeiculoViewModel

class MainActivity : ComponentActivity() {
    private val anoVeiculoViewModel by viewModels<AnoVeiculoViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                        InputLicencePlate()
                    }
                }
            }
        }
    }

    @Composable
    fun InputLicencePlate() {
        val focusManager = LocalFocusManager.current
        Row {
            TextSmallField(
                value = anoVeiculoViewModel.firstField,
                onChange = {
                    anoVeiculoViewModel.onChangeFirstField(it.take(anoVeiculoViewModel.maxChar))
                    if (it.length == anoVeiculoViewModel.maxChar) {
                        focusManager.moveFocus(FocusDirection.Next)
                    }
                },
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                }),
                imeActions = ImeAction.Next
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextSmallField(
                value = anoVeiculoViewModel.secondField,
                onChange = {
                    anoVeiculoViewModel.onChangeSecondField(it.take(anoVeiculoViewModel.maxChar))
                    if (it.length == anoVeiculoViewModel.maxChar) {
                        focusManager.moveFocus(FocusDirection.Next)
                    }else focusManager.moveFocus(FocusDirection.Left)
                },
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                }),
                imeActions = ImeAction.Next
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextSmallField(
                value = anoVeiculoViewModel.thirdField,
                onChange = {
                    anoVeiculoViewModel.onChangeThirdField(it.take(anoVeiculoViewModel.maxChar))
                    if (it.length == anoVeiculoViewModel.maxChar) {
                        focusManager.moveFocus(FocusDirection.Next)
                    }else focusManager.moveFocus(FocusDirection.Left)
                },
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                }),
                imeActions = ImeAction.Next
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextSmallField(
                value = anoVeiculoViewModel.fourthField,
                onChange = {
                    anoVeiculoViewModel.onChangeFourthField(it.take(anoVeiculoViewModel.maxChar))
                    if (it.length == anoVeiculoViewModel.maxChar) {
                        focusManager.clearFocus()
                    }else focusManager.moveFocus(FocusDirection.Left)
                },
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                imeActions = ImeAction.Done
            )
        }
    }

    @Composable
    fun TextSmallField(
        value: String,
        onChange: (String) -> Unit,
        keyboardActions: KeyboardActions,
        imeActions: ImeAction
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            elevation = 16.dp
        ) {
            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = value, onValueChange = onChange,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = imeActions
                ),
                keyboardActions = keyboardActions,
                modifier = Modifier.size(70.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        }


    }
}