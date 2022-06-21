package com.ozias.reloadz

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import com.ozias.reloadz.ui.AppBarAction
import com.ozias.reloadz.ui.TopAppBar
import com.ozias.reloadz.ui.TopAppBar.searchTestTag
import com.ozias.reloadz.ui.TopAppBar.settingsTestTag
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ReloadZTopAppBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val testTitle = "A Title"

    @Test
    fun appBarSearchClickWorks() {
        composeTestRule.setContent {
            TopAppBar.Ui(testTitle) { assertEquals(it, AppBarAction.Search) }
        }
        composeTestRule.onNode(hasText(testTitle)).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(searchTestTag)).assertHasClickAction()
        composeTestRule.onNode(hasTestTag(searchTestTag)).performClick()
    }

    @Test
    fun appBarSettingsClickWorks() {
        composeTestRule.setContent {
            TopAppBar.Ui(testTitle) { assertEquals(it, AppBarAction.Settings) }
        }
        composeTestRule.onNode(hasText(testTitle)).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag(settingsTestTag)).assertHasClickAction()
        composeTestRule.onNode(hasTestTag(settingsTestTag)).performClick()
    }
}
