package com.example.cryptocurrencyapp_pl_github.presentation.coin_detail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencyapp_pl_github.presentation.coin_detail.components.CoinTag
import com.example.cryptocurrencyapp_pl_github.presentation.coin_detail.components.TeamListItem

@OptIn(ExperimentalLayoutApi::class)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel
) {
    val state = viewModel.state.value

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        state.coin?.let { coin ->
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if (coin.isActive) "Active" else "Inactive",
                            modifier = Modifier.weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = coin.description)
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "Tags")
                    Spacer(modifier = Modifier.size(16.dp))
                    FlowRow() {
                        coin.tags.forEach { CoinTag(tag = it) }
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "Team Members")
                }
                items(coin.team) {
                    TeamListItem(teamMember = it)
                }
//                items(state.coins) { coin ->
//                    CoinListItem(coin = coin,
//                        onItemClick = {
//                            navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
//                        })
//                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}