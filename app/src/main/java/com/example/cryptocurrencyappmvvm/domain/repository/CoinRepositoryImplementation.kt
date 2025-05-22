package com.example.cryptocurrencyappmvvm.domain.repository

import com.example.cryptocurrencyappmvvm.data.remote.CoinPaprikaAPI
import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDetailsDto
import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(
    private val api    : CoinPaprikaAPI

) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
       return api.getCoinById(coinId)
    }
}