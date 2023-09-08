package com.example.modernmvvmarchitecture

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.modernmvvmarchitecture.ui.theme.ModernMVVMArchitectureTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClickToDetailScreen: (Int) -> Unit = {},
    gamesList: LazyPagingItems<Games>? = null
) {
    if (gamesList == null) return

    LazyVerticalGrid(   // Used for scroll instead of RecyclerView
        modifier = Modifier.padding(16.dp),
        columns = GridCells.Adaptive(minSize = 96.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(gamesList.itemCount) { index ->
            gamesList[index].let { games ->
                val id = games?.id
                val name = games?.name ?: ""
                val imageUrl = games?.backgroundImage ?: ""
                val releaseDate = games?.released ?: ""

                ProductCard(
                    modifier = modifier
                        .padding(
                            top = 16.dp
                        ),
                    name = name,
                    imageUrl = imageUrl,
                    releaseDate = releaseDate,
                    onClickProduct = {
                        id?.let {
                            onClickToDetailScreen.invoke(it)
                        }
                    }
                )
            }
        }

        gamesList.apply {
            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                when {
                    loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                        LoadingCircular(
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {
                        ErrorButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Error occurred. Please try again",
                            onClick = {
                                retry()
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ModernMVVMArchitectureTheme {
        HomeScreen()
    }
}