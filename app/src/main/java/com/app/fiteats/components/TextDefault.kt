package com.app.fiteats.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.fiteats.model.Recipe
import com.app.fiteats.ui.theme.poppinsFontFamily


@Composable
fun TextDefault(
    text: String,
    fontFamily: FontFamily = poppinsFontFamily,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 24.sp,
    color: Color = Color.Black,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color,
        modifier = modifier
    )
}

@Composable
fun RecipeTitle(
    recipe: Recipe,
    text: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    textAlign: TextAlign
){
    Text(
        text = text,
        fontSize = fontSize,
        modifier = modifier,
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Composable
fun RecipeSubtitle(
    recipe: Recipe,
    selectedCategory: String,
){
    Text(
        modifier = Modifier.offset(y = (-8).dp),
        text = if (selectedCategory == "All") recipe.category else "${recipe.kcal} kcal",
        fontSize = 11.sp,
        color = Color.Gray,
        fontFamily = poppinsFontFamily,
    )
}

@SuppressLint("DefaultLocale")
@Composable
fun RecipeCost(
    recipe: Recipe,
){
    Text(
        modifier = Modifier.padding(start = 6.dp).offset(y = (-8).dp),
        text = "$${String.format("%.2f",recipe.estimatedCost)}",
        fontSize = 11.sp,
        color = Color.Gray,
        fontFamily = poppinsFontFamily,
    )
}
@SuppressLint("DefaultLocale")
@Composable
fun RecipeCostNoSymbol(
    recipe: Recipe
){
    Text(
        modifier = Modifier.offset(y = (-8).dp),
        text = String.format("%.2f",recipe.estimatedCost),
        fontSize = 11.sp,
        color = Color.Black,
        fontFamily = poppinsFontFamily,
    )
}

@Composable
fun RecipeKcal(
    recipe: Recipe,
){
    Text(
        modifier = Modifier.offset(y = (-8).dp),
        text = "${recipe.kcal} kcal",
        fontSize = 11.sp,
        color = Color.Black,
        fontFamily = poppinsFontFamily,
    )
}

@Composable
fun RecipeTime(
    recipe: Recipe,
){
    Text(
        modifier = Modifier.offset(y = (-8).dp),
        text = "${recipe.estimatedTime}'",
        fontSize = 11.sp,
        color = Color.Black,
        fontFamily = poppinsFontFamily,
    )
}

@Composable
fun RecipeServings(
    recipe: Recipe,
){
    Text(
        modifier = Modifier.offset(y = (-8).dp),
        text = "${recipe.servings} servings",
        fontSize = 11.sp,
        color = Color.Black,
        fontFamily = poppinsFontFamily,
    )
}