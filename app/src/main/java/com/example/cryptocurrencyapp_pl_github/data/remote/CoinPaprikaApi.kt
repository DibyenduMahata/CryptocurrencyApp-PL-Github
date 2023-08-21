package com.example.cryptocurrencyapp_pl_github.data.remote

import com.example.cryptocurrencyapp_pl_github.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyapp_pl_github.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}

// https://api.coinpaprika.com/v1/coins
// https://api.coinpaprika.com/v1/coins/btc-bitcoin