package com.example.cryptocurrencyapp_pl_github.presentation.coin_detail

import com.example.cryptocurrencyapp_pl_github.domain.model.Coin
import com.example.cryptocurrencyapp_pl_github.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
