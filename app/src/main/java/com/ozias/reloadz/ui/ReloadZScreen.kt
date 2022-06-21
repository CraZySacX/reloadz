package com.ozias.reloadz.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import arrow.core.Option
import arrow.core.getOrElse
import arrow.core.some
import com.ozias.reloadz.R
import com.ozias.reloadz.state.ReloadZTab
import com.ozias.reloadz.state.ReloadZTabKind
import com.ozias.reloadz.state.rememberReloadZState
import com.ozias.reloadz.ui.theme.ReloadZTheme
import com.ozias.reloadz.ui.utils.CircularIndeterminateProgressBar
import com.ozias.reloadz.ui.utils.TransparentSystemBars
import com.ozias.reloadz.viewmodel.ReloadZViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReloadZScreen(viewModel: ReloadZViewModel = viewModel()) {
    val state = rememberReloadZState()
    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    viewModel.init(state.tabs.first())

    TransparentSystemBars(
        systemUiController = state.systemUiController,
        useDarkIcons = state.useDarkIcons
    )
    ReloadZTheme {
        ModalBottomSheetLayout(
            sheetContent = {
                Column(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                ) {
                    Card(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
                        Text("Enter Load Data", fontSize = 24.sp)
                    }
                    Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp)
                    LazyColumn(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                        items(10) {
                            Text(text = "Item $it")
                        }
                    }
                }
            },
            sheetState = bottomSheetState,
            sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = state.scaffoldState,
                topBar = {
                    val hostState = state.scaffoldState.snackbarHostState
                    val title = viewModel.currentTab.map { it.title }.getOrElse { "ReloadZ" }
                    TopAppBar.Ui(text = title) { handleTopAppBarClick(it, scope, hostState) }
                },
                floatingActionButton = {
                    val currTab = viewModel.currentTab
                    val hostState = state.scaffoldState.snackbarHostState
                    val cd = viewModel.currentTab.map {
                        when (it.kind) {
                            ReloadZTabKind.Load -> stringResource(R.string.add_load_data_cd)
                            ReloadZTabKind.Range -> stringResource(R.string.add_range_data_cd)
                        }
                    }.getOrElse { "add" }
                    Fab.Ui(cd) { handleFabClick(currTab, scope, bottomSheetState) }
                },
                content = {
                    val currIndex = viewModel.currentTab.map { it.index }.getOrElse { 0 }
                    val loading = viewModel.loading
                    Column {
                        TabRow.Ui(currIndex, state.tabs) { handleTabRowClick(viewModel, it) }
                        if (!loading) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                viewModel.currentTab.map {
                                    when (it.kind) {
                                        ReloadZTabKind.Load -> Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 8.dp, bottom = 8.dp)
                                                .clickable { },
                                            shape = RoundedCornerShape(10.dp),
                                            backgroundColor = MaterialTheme.colors.secondary,
                                            contentColor = MaterialTheme.colors.onSecondary
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Row {
                                                    Text(
                                                        "Tikka T3 Tac A1",
                                                        modifier = Modifier.padding(8.dp)
                                                    )
                                                    Text(
                                                        "6.5 Creedmoor",
                                                        modifier = Modifier.padding(8.dp)
                                                    )
                                                }
                                                Box(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    contentAlignment = Alignment.CenterEnd
                                                ) {
                                                    Text(
                                                        "03/22/1976",
                                                        modifier = Modifier.padding(8.dp)
                                                    )
                                                }
                                            }
                                        }
                                        ReloadZTabKind.Range -> Text("Range Data")
                                    }
                                }
                            }
                        }
                    }
                    if (loading) {
                        CircularIndeterminateProgressBar(isDisplayed = loading)
                    }
                }
            )
        }
    }
}

fun handleTopAppBarClick(
    appBarAction: AppBarAction,
    scope: CoroutineScope,
    state: SnackbarHostState
) {
    when (appBarAction) {
        AppBarAction.Search -> scope.launch { state.showSnackbar("You wish to search?") }
        AppBarAction.Settings -> scope.launch { state.showSnackbar("Settings coming up") }
    }
}

@OptIn(ExperimentalMaterialApi::class)
private fun handleFabClick(
    maybeCurrTab: Option<ReloadZTab>,
    scope: CoroutineScope,
    state: ModalBottomSheetState
) {
    maybeCurrTab.map { currTab ->
        when (currTab.kind) {
            ReloadZTabKind.Load -> scope.launch { state.show() }
            ReloadZTabKind.Range -> scope.launch { state.show() }
        }
    }
}

private fun handleTabRowClick(viewModel: ReloadZViewModel, tab: ReloadZTab) {
    viewModel.currentTab = tab.some()
    when (tab.kind) {
        ReloadZTabKind.Load -> viewModel.fetchLoadData()
        ReloadZTabKind.Range -> viewModel.fetchRangeData()
    }
}
