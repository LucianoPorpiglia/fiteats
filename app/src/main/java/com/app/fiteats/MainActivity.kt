package com.app.fiteats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.app.fiteats.data.recipes
import com.app.fiteats.navigation.NavManager
import com.app.fiteats.onboarding.OnBoardingScreen
import com.app.fiteats.ui.theme.FitEatsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitEatsTheme {
                // A surface container using the 'background' color from the theme
                NavManager()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    FitEatsTheme {
        OnBoardingScreen(navController = rememberNavController())
    }
}