package com.ozias.reloadz.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController

@Composable
fun TransparentSystemBars(systemUiController: SystemUiController, useDarkIcons: Boolean) {
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !useDarkIcons
        )
    }
}
