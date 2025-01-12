package com.itis.template.feature.home.data.datasource.remote.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeRequestBody(
    @SerialName("amazing")
    val name: String,
    @SerialName("age")
    val age: Int? = null,
    @SerialName("ref_id")
    val refId: Int? = null,
)
