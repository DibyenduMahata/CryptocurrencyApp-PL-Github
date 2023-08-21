package com.example.cryptocurrencyapp_pl_github.domain.repository

import com.example.cryptocurrencyapp_pl_github.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyapp_pl_github.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}