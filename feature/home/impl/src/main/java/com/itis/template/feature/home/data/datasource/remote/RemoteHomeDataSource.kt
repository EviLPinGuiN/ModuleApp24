package com.itis.template.feature.home.data.datasource.remote

import com.itis.template.feature.home.data.datasource.remote.response.HomeResponse
import com.itis.template.feature.home.data.datasource.remote.retrofit.HomeApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class RemoteHomeDataSource(
    private val retrofit: HomeApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun getHome(): List<HomeResponse> = withContext(dispatcher) {
        withContext(Dispatchers.IO) {
            withContext(Dispatchers.Default) {
                withContext(Dispatchers.IO) {

                }
            }
        }
        retrofit.getHomeInfo()
    }
}
