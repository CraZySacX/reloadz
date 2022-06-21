package com.ozias.reloadz.state

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Hive
import androidx.compose.material.icons.filled.Support
import androidx.compose.ui.graphics.vector.ImageVector
import com.ozias.reloadz.R

enum class ReloadZTabKind {
    Load,
    Range,
}

data class ReloadZTab(
    val index: Int,
    val kind: ReloadZTabKind,
    val title: String,
    val icon: ImageVector,
    val iconContentDescription: String
)

data class ReloadZTabConfig(
    val index: Int,
    val kind: ReloadZTabKind,
    val title: Int,
    val icon: ImageVector,
    val iconContentDescription: Int
) {
    companion object {
        fun init(): List<ReloadZTabConfig> {
            return listOf(loadData(), rangeData())
        }

        private fun loadData(): ReloadZTabConfig {
            return ReloadZTabConfig(
                index = 0,
                kind = ReloadZTabKind.Load,
                title = R.string.load_data,
                icon = Icons.Default.Hive,
                iconContentDescription = R.string.load_data_cd
            )
        }

        private fun rangeData(): ReloadZTabConfig {
            return ReloadZTabConfig(
                index = 1,
                kind = ReloadZTabKind.Range,
                title = R.string.range_data,
                icon = Icons.Default.Support,
                iconContentDescription = R.string.range_data_cd
            )
        }
    }
}
