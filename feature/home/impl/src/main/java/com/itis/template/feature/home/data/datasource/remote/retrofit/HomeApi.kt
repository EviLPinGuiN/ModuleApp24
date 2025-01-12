package com.itis.template.feature.home.data.datasource.remote.retrofit

import com.itis.template.feature.home.data.datasource.remote.response.HomeResponse
import retrofit2.http.GET

interface HomeApi {

    @GET("url/home")
    suspend fun getHomeInfo(): List<HomeResponse>
}