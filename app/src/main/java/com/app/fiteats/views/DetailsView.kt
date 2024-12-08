package com.app.fiteats.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.app.fiteats.R
import com.app.fiteats.components.IconRow
import com.app.fiteats.components.RecipeCostNoSymbol
import com.app.fiteats.components.RecipeKcal
import com.app.fiteats.components.RecipeServings
import com.app.fiteats.components.RecipeTime
import com.app.fiteats.components.RecipeTitle
import com.app.fiteats.components.SpacerH
import com.app.fiteats.components.SpacerW
import com.app.fiteats.components.TextDefault
import com.app.fiteats.data.recipes

@SuppressLint("DefaultLocale")
@Composable
fun DetailsView(
    navController: NavController,
    recipeName: String,
) {

    val recipe = recipes.find { it.name == recipeName } ?: return

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFe5e5e5))
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(start = 6.dp, end = 6.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    RecipeTitle(
                        recipe,
                        text = " ${recipe.name}",
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(onClick = { println("Like") }) {
                        Icon(
                            painter = painterResource(R.drawable.like),
                            contentDescription = "Like",
                            tint = Color.Black,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            }
            item {
                AsyncImage(
                    model = recipe.imageUrl,
                    contentDescription = "Recipe Image",
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .height(200.dp)
                )
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconRow(
                        painter = painterResource(id = R.drawable.cost1),
                        "Money Icon"
                    )
                    RecipeCostNoSymbol(recipe)

                    SpacerW()

                    IconRow(
                        painter = painterResource(id = R.drawable.kcal),
                        "Kcal Icon"
                    )
                    RecipeKcal(recipe)

                    SpacerW()

                    IconRow(
                        painter = painterResource(id = R.drawable.serving),
                        "Serving Icon"
                    )
                    RecipeServings(recipe)

                    SpacerW()

                    IconRow(
                        painter = painterResource(id = R.drawable.timer),
                        "Timer Icon"
                    )
                    RecipeTime(recipe)
                }
            }
            item {
                TextDefault(
                    "Ingredients",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
                SpacerH(10.dp)
            }
            //ingredients
            itemsIndexed(recipe.ingredients) { index, ingredient ->
                Text(
                    text = "● $ingredient",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp)
                )
            }
            item {
                SpacerH(10.dp)
                TextDefault(
                    "Instructions",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
                SpacerH(10.dp)
            }
            //instructions
            itemsIndexed(recipe.instructions) { index, instruction ->

                Text(
                    text = "- $instruction",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp)
                )
            }
        }
    }
}