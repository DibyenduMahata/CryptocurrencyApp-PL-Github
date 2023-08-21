package com.example.cryptocurrencyapp_pl_github.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrencyapp_pl_github.presentation.coin_detail.CoinDetailScreen
import com.example.cryptocurrencyapp_pl_github.presentation.coin_detail.CoinDetailViewModel
import com.example.cryptocurrencyapp_pl_github.presentation.coin_list.CoinListScreen
import com.example.cryptocurrencyapp_pl_github.presentation.coin_list.CoinListViewModel
import com.example.cryptocurrencyapp_pl_github.ui.theme.CryptocurrencyAppPLGithubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val coinListViewModel by viewModels<CoinListViewModel>()
    private val coinDetailViewModel by viewModels<CoinDetailViewModel>()

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppPLGithubTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(Screen.CoinListScreen.route) {
                            CoinListScreen(
                                navController = navController,
                                viewModel = coinListViewModel
                            )
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}") {
                            CoinDetailScreen(
                                viewModel = coinDetailViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}