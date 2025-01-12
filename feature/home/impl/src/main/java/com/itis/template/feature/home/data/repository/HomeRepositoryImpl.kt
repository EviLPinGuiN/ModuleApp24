package com.itis.template.feature.home.data.repository

import com.itis.template.feature.home.api.model.Home
import com.itis.template.feature.home.api.repository.HomeRepository
import com.itis.template.feature.home.data.datasource.local.LocalHomeDataSource
import com.itis.template.feature.home.data.datasource.memory.MemoryHomeDataSource
import com.itis.template.feature.home.data.datasource.remote.RemoteHomeDataSource
import com.itis.template.feature.home.data.mapper.mapList

internal class HomeRepositoryImpl(
    val memorySource: MemoryHomeDataSource,
    val localSource: LocalHomeDataSource,
    val remoteSource: RemoteHomeDataSource,
) : HomeRepository {

    override suspend fun getAllHome(): List<Home> {
        return remoteSource.getHome().mapList()
    }
}
