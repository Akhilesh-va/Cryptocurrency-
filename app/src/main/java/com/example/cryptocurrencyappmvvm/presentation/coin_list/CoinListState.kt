package com.example.cryptocurrencyappmvvm.presentation.coin_list

import com.example.cryptocurrencyappmvvm.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean=false,
    val coins : List<Coin> = emptyList(),
    val error : String = ""
)
