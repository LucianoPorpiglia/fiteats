package com.app.fiteats.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.fiteats.model.Recipe
import com.app.fiteats.onboarding.OnBoardingScreen
import com.app.fiteats.views.DetailsView
import com.app.fiteats.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "onboarding") {
        composable("onboarding") { OnBoardingScreen(navController) }
        composable("home") { HomeView(navController) }
        composable("details/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            name?.let { DetailsView(navController, it) }
        }
    }
}

