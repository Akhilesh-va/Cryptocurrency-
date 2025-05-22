package com.example.cryptocurrencyappmvvm.di

import com.example.cryptocurrencyappmvvm.common.Constants
import com.example.cryptocurrencyappmvvm.data.remote.CoinPaprikaAPI
import com.example.cryptocurrencyappmvvm.domain.repository.CoinRepository
import com.example.cryptocurrencyappmvvm.domain.repository.CoinRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule{
    @Provides
    @Singleton
    fun providePaprikaApi():CoinPaprikaAPI{
        return Retrofit.Builder()
            .baseUrl(Constants. BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)

    }
    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaAPI): CoinRepository {
        return CoinRepositoryImplementation(api)
    }


}
//val appModule = module {
//    single<CoinPaprikaAPI> {
//        Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(CoinPaprikaAPI::class.java)
//    }
//
//    single<CoinRepository> { CoinRepositoryImplementation(get()) }
//}