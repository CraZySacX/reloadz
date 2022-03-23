package com.ozias.reloadz.state

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class ReloadZState(val scaffoldState: ScaffoldState, val systemUiController: SystemUiController)

@Composable
fun rememberReloadZState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    systemUiController: SystemUiController = rememberSystemUiController(),
) = remember(scaffoldState, systemUiController) {
    ReloadZState(scaffoldState, systemUiController)
}
