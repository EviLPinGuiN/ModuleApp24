package com.itis.template.feature.home.data.mapper

import com.itis.template.feature.home.api.model.Home
import com.itis.template.feature.home.data.datasource.remote.response.HomeResponse

fun List<HomeResponse>.mapList(): List<Home> = map {
    it.toDomain()
}

fun HomeResponse.toDomain(): Home = Home(
    id = requireNotNull(id),
    name = requireNotNull(name),
    desc = description ?: -1,
)
