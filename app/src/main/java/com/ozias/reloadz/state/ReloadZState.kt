package com.ozias.reloadz.state

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class ReloadZState(
    val scaffoldState: ScaffoldState,
    val systemUiController: SystemUiController,
    val useDarkIcons: Boolean,
    val tabs: List<ReloadZTab>
)

@Composable
fun rememberReloadZState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    systemUiController: SystemUiController = rememberSystemUiController(),
    useDarkIcons: Boolean = isSystemInDarkTheme(),
    tabs: List<ReloadZTab> = ReloadZTabConfig.init().map {
        ReloadZTab(
            it.index,
            it.kind,
            stringResource(id = it.title),
            it.icon,
            stringResource(id = it.iconContentDescription)
        )
    }
) = remember(scaffoldState, systemUiController, useDarkIcons, tabs) {
    ReloadZState(scaffoldState, systemUiController, useDarkIcons, tabs)
}
