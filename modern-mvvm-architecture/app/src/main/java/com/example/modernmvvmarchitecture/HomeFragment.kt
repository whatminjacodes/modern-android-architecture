package com.example.modernmvvmarchitecture

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.modernmvvmarchitecture.ui.theme.ModernMVVMArchitectureTheme

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeFragmentPreview() {
    ModernMVVMArchitectureTheme {
        HomeFragment()
    }
}