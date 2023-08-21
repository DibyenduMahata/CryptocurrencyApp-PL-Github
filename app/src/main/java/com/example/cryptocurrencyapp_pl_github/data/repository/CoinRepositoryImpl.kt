package com.example.cryptocurrencyapp_pl_github.data.repository

import com.example.cryptocurrencyapp_pl_github.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyapp_pl_github.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyapp_pl_github.data.remote.dto.CoinDto
import com.example.cryptocurrencyapp_pl_github.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}