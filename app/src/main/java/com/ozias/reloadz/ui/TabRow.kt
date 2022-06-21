package com.ozias.reloadz.ui

import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ozias.reloadz.state.ReloadZTab

object TabRow {
    @Composable
    fun Ui(
        currTabIndex: Int,
        tabs: List<ReloadZTab>,
        onClick: (ReloadZTab) -> Unit
    ) {
        TabRow(selectedTabIndex = currTabIndex) {
            for (tab in tabs) {
                Tab(
                    text = { Text(tab.title) },
                    icon = { Icon(tab.icon, contentDescription = tab.iconContentDescription) },
                    selected = currTabIndex == tab.index,
                    onClick = { onClick(tab) }
                )
            }
        }
    }
}
