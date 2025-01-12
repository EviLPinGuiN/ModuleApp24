package com.itis.template.feature.home.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itis.template.feature.home.presentation.HomeViewModel
import com.itis.template.feature.home.presentation.model.Click
import com.itis.template.feature.home.presentation.model.HomeAction
import com.itis.template.feature.home.presentation.model.HomeIntent
import com.itis.template.feature.home.presentation.model.HomeViewState
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    openProfile: Click,
    openCheckout: Click,
    openOrder: Click,
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()
    val viewAction by viewModel.viewAction.collectAsStateWithLifecycle(null)

    HomeView(
        state = viewState,
        consumer = viewModel::onIntent,
    )

    LaunchedEffect(viewAction) {
        when (viewAction) {
            HomeAction.Close -> TODO()
            null -> TODO()
        }
    }
}

@Composable
private fun HomeView(
    state: HomeViewState,
    consumer: (HomeIntent) -> Unit,
) {
    Box {
        Header(
            onCloseClick = {
                consumer(HomeIntent.OnCloseClick)
            }
        )


        AnimatedVisibility(visible = state.title != null) {
            state.title?.let {
                UserName(it)
            }
        }
    }
}

@Composable
private fun UserName(name: String) {

}

// not good
@Composable
private fun Header(
    consumer: (HomeIntent) -> Unit,
) {

}

// good
@Composable
private fun Header(
    onCloseClick: () -> Unit
) {

}

@Preview
@Composable
private fun HomeScreenViewPreview_Loading() {
    HomeView(
        state = HomeViewState(
            isLoading = true,
            title = "",
            homeList = persistentListOf(),
            requestPerm = {}
        ),
        consumer = {}
    )
}

@Preview
@Composable
private fun HomeScreenViewPreview_Content() {
    HomeView(
        state = HomeViewState(
            isLoading = false,
            title = "Title",
            homeList = persistentListOf(),
            requestPerm = {}
        ),
        consumer = {}
    )
}

@Preview
@Composable
private fun HomeScreenViewPreview_Error() {
    HomeView(
        state = HomeViewState(
            isLoading = true,
            title = "",
            homeList = persistentListOf(),
            requestPerm = {}
        ),
        consumer = {}
    )
}
