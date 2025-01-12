package com.itis.template.feature.home

import com.itis.template.feature.home.api.repository.HomeRepository
import com.itis.template.feature.home.api.usecase.GetHomeListUseCase
import com.itis.template.feature.home.data.datasource.local.LocalHomeDataSource
import com.itis.template.feature.home.data.datasource.memory.MemoryHomeDataSource
import com.itis.template.feature.home.data.datasource.remote.RemoteHomeDataSource
import com.itis.template.feature.home.data.datasource.remote.retrofit.HomeApi
import com.itis.template.feature.home.data.repository.HomeRepositoryImpl
import com.itis.template.feature.home.usecase.GetHomeListUseCaseImpl
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory



val homeModule = module {

// ---
    single<OkHttpClient> {
        OkHttpClient.Builder()
//            .addInterceptor()
            .build()
    }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("http://test.com")
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .client(get())
            .build()
    }
    // ---

    single<HomeApi> {
        get<Retrofit>().create(HomeApi::class.java)
    }

    factory<MemoryHomeDataSource> { MemoryHomeDataSource() }
    factory<RemoteHomeDataSource> { RemoteHomeDataSource(get()) }
    factory<LocalHomeDataSource> { LocalHomeDataSource() }

    factory<HomeRepository> { HomeRepositoryImpl(get(), get(), get()) }

    factory<GetHomeListUseCase> { GetHomeListUseCaseImpl(get(), get()) }
}