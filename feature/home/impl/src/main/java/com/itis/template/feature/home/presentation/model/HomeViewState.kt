package com.itis.template.feature.home.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.itis.template.feature.home.api.model.Home
import com.itis.template.feature.home.presentation.HomeViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class HomeViewState(
    val isLoading: Boolean = false,
    val title: String? = "default titile",
    val homeList: ImmutableList<Home> = persistentListOf(),
    val requestPerm: (() -> Unit)? = null,
)

typealias Click = () -> Unit

@Composable
fun Test(
    name: String, // "test"  // test
    desc: String, // "desc" // desc
    age: List<Int>, // 2 // 2 // 3
    onClick: Click // {} // {}
) {

//    val viewState = vi
//    staticCompositionLocalOf(onClick) // immutable

//    compositionLocalOf() // dynamic
}
