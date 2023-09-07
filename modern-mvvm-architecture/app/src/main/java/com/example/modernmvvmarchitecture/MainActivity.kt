package com.example.modernmvvmarchitecture

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost      // deprecated
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.modernmvvmarchitecture.ui.theme.ModernMVVMArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // This theme is setup in Theme.kt file
            ModernMVVMArchitectureTheme {
                ModernMVVMArchitectureAppScreen()
            }
        }
    }
}

@Composable
fun ModernMVVMArchitectureAppScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.Home.route,
    ) {
        composable(route = Route.Home.route) {
            HomeFragment(
                onClickToDetailScreen = { productId ->
                    navController.navigate(
                        Route.Detail.createRoute(productId)
                    )
                }
            )
        }
        composable(
            route = Route.Detail.route,
            arguments = listOf(
                navArgument("productId"){
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            requireNotNull(productId) { "productId parameter wasn't found. Please make sure it's set!" }
            DetailFragment(id = productId)
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ModernMVVMArchitectureAppScreenPreview() {
    ModernMVVMArchitectureTheme {
        ModernMVVMArchitectureAppScreen()
    }
}