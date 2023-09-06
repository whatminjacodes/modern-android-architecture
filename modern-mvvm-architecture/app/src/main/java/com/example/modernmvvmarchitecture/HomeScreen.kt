package com.example.modernmvvmarchitecture

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modernmvvmarchitecture.ui.theme.ModernMVVMArchitectureTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(   // Used for scroll instead of RecyclerView
        modifier = Modifier.padding(16.dp),
        columns = GridCells.Adaptive(minSize = 96.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(60) {
            ProductCard()
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