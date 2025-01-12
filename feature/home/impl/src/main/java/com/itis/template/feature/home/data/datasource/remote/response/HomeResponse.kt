package com.itis.template.feature.home.data.datasource.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeResponse(
    @SerialName("home_id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("description")
    val description: Int? = null,
)
