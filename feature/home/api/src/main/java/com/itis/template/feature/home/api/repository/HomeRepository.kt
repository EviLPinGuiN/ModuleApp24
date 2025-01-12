package com.itis.template.feature.home.api.repository

import com.itis.template.feature.home.api.model.Home

interface HomeRepository {

    suspend fun getAllHome(): List<Home>
}