package com.example.modernmvvmarchitecture

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.modernmvvmarchitecture.ui.theme.ModernMVVMArchitectureTheme

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    onClickToDetailScreen: (Int) -> Unit = {},
    homeViewModel: HomeViewModel = viewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        HomeScreen(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                ),
            onClickToDetailScreen = onClickToDetailScreen,
            gamesList = homeViewModel.gamesListState.collectAsLazyPagingItems()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeFragmentPreview() {
    ModernMVVMArchitectureTheme {
        HomeFragment()
    }
}