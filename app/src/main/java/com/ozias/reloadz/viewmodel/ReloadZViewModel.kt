package com.ozias.reloadz.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.None
import arrow.core.Option
import arrow.core.some
import com.ozias.reloadz.state.ReloadZTab
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReloadZViewModel @Inject constructor() : ViewModel() {
    var currentTab by mutableStateOf<Option<ReloadZTab>>(None)

    var loading by mutableStateOf(false)
        private set

    fun init(tab: ReloadZTab) {
        currentTab = tab.some()
        fetchLoadData()
    }

    fun fetchLoadData() {
        viewModelScope.launch {
            loading = true
            delay(2000)
            loading = false
        }
    }

    fun fetchRangeData() {
        viewModelScope.launch {
            loading = true
            delay(2000)
            loading = false
        }
    }
}
