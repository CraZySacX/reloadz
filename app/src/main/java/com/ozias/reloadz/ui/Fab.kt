package com.ozias.reloadz.ui

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

object Fab {
    @Composable
    fun Ui(contentDescription: String, onClick: () -> Unit) {
        FloatingActionButton(
            modifier = Modifier
                .navigationBarsPadding()
                .testTag(fabTestTag),
            onClick = onClick
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = contentDescription
            )
        }
    }

    const val fabTestTag = "fab"
}
