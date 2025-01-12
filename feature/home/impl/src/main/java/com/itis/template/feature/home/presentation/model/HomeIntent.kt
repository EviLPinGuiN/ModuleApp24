package com.itis.template.feature.home.presentation.model

sealed class HomeIntent {

    data object OnCloseClick : HomeIntent()
}