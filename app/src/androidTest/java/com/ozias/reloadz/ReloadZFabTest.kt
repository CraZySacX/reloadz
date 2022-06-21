package com.ozias.reloadz

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import com.ozias.reloadz.ui.Fab
import com.ozias.reloadz.ui.Fab.fabTestTag
import org.junit.Rule
import org.junit.Test

class ReloadZFabTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val cd = "add stuff"

    @Test
    fun fabClickWorks() {
        composeTestRule.setContent {
            Fab.Ui(cd) { assert(true) }
        }
        composeTestRule.onNodeWithContentDescription(cd).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(fabTestTag)).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(fabTestTag)).assertHasClickAction()
        composeTestRule.onNode(hasTestTag(fabTestTag)).performClick()
    }
}
