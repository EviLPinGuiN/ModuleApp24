package com.itis.template.feature.home.presentation.model

sealed class HomeAction {

    data object Close: HomeAction()
}