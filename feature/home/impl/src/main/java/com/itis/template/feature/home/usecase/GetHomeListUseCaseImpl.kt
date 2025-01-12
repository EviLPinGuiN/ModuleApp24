package com.itis.template.feature.home.usecase

import com.itis.template.feature.home.api.repository.HomeRepository
import com.itis.template.feature.home.api.usecase.GetHomeListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class GetHomeListUseCaseImpl(
    private val repository: HomeRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) : GetHomeListUseCase {

    override suspend fun invoke() = withContext(dispatcher) {
        repository.getAllHome()
    }
}
