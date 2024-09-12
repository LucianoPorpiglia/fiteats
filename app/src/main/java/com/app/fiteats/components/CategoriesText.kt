package com.app.fiteats.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.fiteats.ui.theme.poppinsFontFamily

@Composable
fun CategoriesText(
    navController: NavController,
    text: String,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
){
    Text(
        text = text,
        color = if (selectedCategory == text) Color.Black else Color.Gray,
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .clickable {
                onCategorySelected(text)
            }
    )
}
