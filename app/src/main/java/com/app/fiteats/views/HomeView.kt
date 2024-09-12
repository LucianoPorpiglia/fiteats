package com.app.fiteats.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import com.app.fiteats.components.TextDefault
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.app.fiteats.components.CategoriesText
import com.app.fiteats.components.RecipeCost
import com.app.fiteats.components.RecipeSubtitle
import com.app.fiteats.components.RecipeTitle
import com.app.fiteats.components.SearchBarM3
import com.app.fiteats.components.SpacerH
import com.app.fiteats.data.recipes

@SuppressLint("RememberReturnType")
@Composable
fun HomeView(navController: NavController) {

    val customColor = Color(0xFF266F58)
    val backgroundColor = Color(0xFFe5e5e5)

    val categoriesList = listOf(
        "All",
        "Low-Calorie",
        "High-Protein",
        "Vegetarian",
        "Vegan",
        "Gluten-Free"
    )

    val selectedCategory = remember { mutableStateOf("All") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            TextDefault(
                "Hi Luciano",
                color = customColor,
                fontSize = 18.sp,
                fontWeight = Bold
            )
            TextDefault(
                "Find Your Food",
                fontWeight = Bold,
                fontSize = 24.sp
            )

            SpacerH()

            SearchBarM3()

            SpacerH(15.dp)

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                items(categoriesList) { category ->
                    CategoriesText(
                        navController = navController,
                        text = category,
                        selectedCategory = selectedCategory.value,
                        onCategorySelected = { selectedCategory.value = it }
                    )
                }
            }
            RecipeList(selectedCategory.value, navController)
        }
    }
}

@Composable
fun RecipeList(selectedCategory: String,navController: NavController) {

    val backgroundColor = Color(0xFFe5e5e5)

    val filteredRecipes = if (selectedCategory == "All") {
        recipes
    } else {
        recipes.filter { it.category == selectedCategory }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor),
        contentPadding = PaddingValues(2.dp)
    ) {
        items(filteredRecipes) { recipe ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
                    .background(color = backgroundColor)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = backgroundColor)
                        .padding(2.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = recipe.imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp) // Define un tamaño fijo para todas las imágenes
                            .clip(RoundedCornerShape(6.dp))
                            .clickable {
                                navController.navigate("details/${recipe.name}")
                            },
                        contentScale = ContentScale.Crop
                    )

                    RecipeTitle(
                        recipe,
                        text = recipe.name,
                        fontSize = 14.sp,
                        Modifier.padding(top = 4.dp),
                        textAlign = TextAlign.Center
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        RecipeSubtitle(recipe,selectedCategory)
                        RecipeCost(recipe)
                    }
                }
            }
        }
    }
}


