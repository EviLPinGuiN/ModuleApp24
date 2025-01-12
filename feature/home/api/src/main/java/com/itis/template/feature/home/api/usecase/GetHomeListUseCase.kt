package com.itis.template.feature.home.api.usecase

import com.itis.template.feature.home.api.model.Home

interface GetHomeListUseCase {

    suspend operator fun invoke(): List<Home>
}