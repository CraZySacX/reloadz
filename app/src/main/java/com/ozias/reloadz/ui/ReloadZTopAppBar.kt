package com.ozias.reloadz.ui

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.ozias.reloadz.R

enum class AppBarAction {
    Search,
    Settings,
}

object TopAppBar {
    @Composable
    fun Ui(text: String, onAction: (AppBarAction) -> Unit) {
        TopAppBar(
            modifier = Modifier.statusBarsPadding(),
            title = { Text(text = text) },
            actions = {
                IconButton(
                    modifier = Modifier.testTag(searchTestTag),
                    onClick = { onAction(AppBarAction.Search) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search_cd)
                    )
                }
                IconButton(
                    modifier = Modifier.testTag(settingsTestTag),
                    onClick = { onAction(AppBarAction.Settings) }
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = stringResource(R.string.settings_cd)
                    )
                }
            }
        )
    }

    const val searchTestTag = "search"
    const val settingsTestTag = "settings"
}
