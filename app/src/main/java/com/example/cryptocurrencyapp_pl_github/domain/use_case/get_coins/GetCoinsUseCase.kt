package com.example.cryptocurrencyapp_pl_github.domain.use_case.get_coins

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptocurrencyapp_pl_github.common.Resource
import com.example.cryptocurrencyapp_pl_github.data.remote.dto.toCoin
import com.example.cryptocurrencyapp_pl_github.domain.model.Coin
import com.example.cryptocurrencyapp_pl_github.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())

            val coins = repository.getCoins().map { it.toCoin() }

            emit(Resource.Success(coins))

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "An Unexpected Error Occurred!"))

        } catch (e: IOException) {

            emit(Resource.Error("Couldn't reach server, check your internet connection."))

        }
    }
}