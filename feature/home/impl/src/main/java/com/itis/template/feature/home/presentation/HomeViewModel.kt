package com.itis.template.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itis.template.feature.home.presentation.model.HomeAction
import com.itis.template.feature.home.presentation.model.HomeIntent
import com.itis.template.feature.home.presentation.model.HomeViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State, Intent, Action>(
    initState: State
) : ViewModel() {

    private val _uiState = MutableStateFlow(initState)
    private val _action = MutableSharedFlow<Action>(replay = 0)

    protected var uiState: State
        get() = _uiState.value
        set(value) {
            _uiState.value = value
        }

    protected var action: Action?
        get() = if (_action.replayCache.isNotEmpty()) {
            _action.replayCache.last()
        } else {
            null
        }
        set(value) {
            viewModelScope.launch {
                if (value != null) {
                    _action.emit(value)
                } else {
                    _action.resetReplayCache()
                }
            }
        }

    val viewState: StateFlow<State>
        get() = _uiState.asStateFlow()
    val viewAction: Flow<Action>
        get() = _action.asSharedFlow()

    abstract fun onIntent(intent: Intent)
}

class HomeViewModel : BaseViewModel<HomeViewState, HomeIntent, HomeAction>(
    initState = HomeViewState()
) {

    override fun onIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.OnCloseClick -> onCloseClick()
        }
    }

    private fun onCloseClick() {
        /// todo
    }
}