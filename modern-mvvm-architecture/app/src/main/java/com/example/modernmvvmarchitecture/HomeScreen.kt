package com.example.modernmvvmarchitecture

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.modernmvvmarchitecture.ui.theme.ModernMVVMArchitectureTheme

@Composable
fun HomeScreen(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ModernMVVMArchitectureTheme {
        HomeScreen("Android in HomeScreen")
    }
}