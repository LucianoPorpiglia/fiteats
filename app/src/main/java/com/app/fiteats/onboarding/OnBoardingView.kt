package com.app.fiteats.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.fiteats.R
import com.app.fiteats.navigation.NavManager
import com.app.fiteats.widget.button.CustomButton
import com.app.fiteats.widget.button.FirstButton

@Composable
fun OnBoardingScreen(navController: NavController) {

    val backgroundColor = Color(0xFF266F58)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboard2),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .offset(y = 60.dp)
                    .fillMaxWidth()
                    .height(320.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Nutritious Meals for\na Better You",
                fontSize = 28.sp,
                color = Color(0xFFe5e5e5),
                modifier = Modifier
                    .offset(y = 90.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                lineHeight = 30.sp
            )
            Text(
                text = "Easy recipes and tips for nutritious\nmeals every day.",
                fontSize = 18.sp,
                color = Color(0xFFe5e5e5),
                modifier = Modifier
                    .offset(y = 100.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(270.dp))

            FirstButton(
                modifier = Modifier
                    .fillMaxWidth(),
                textId = R.string.next
            ) {
                navController.navigate("home")
            }
        }
    }
}