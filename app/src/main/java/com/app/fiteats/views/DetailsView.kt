package com.app.fiteats.views

import android.annotation.SuppressLint
import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.app.fiteats.R
import com.app.fiteats.components.IconRow
import com.app.fiteats.components.RecipeCost
import com.app.fiteats.components.RecipeCostNoSymbol
import com.app.fiteats.components.RecipeKcal
import com.app.fiteats.components.RecipeServings
import com.app.fiteats.components.RecipeTime
import com.app.fiteats.components.RecipeTitle
import com.app.fiteats.components.SpacerH
import com.app.fiteats.components.SpacerW
import com.app.fiteats.components.TextDefault
import com.app.fiteats.data.recipes
import com.app.fiteats.ui.theme.poppinsFontFamily

@SuppressLint("DefaultLocale")
@Composable
fun DetailsView(
    navController: NavController,
    recipeName: String,
) {

    val recipe = recipes.find { it.name == recipeName } ?: return

    LazyColumn(
        modifier = Modifier
            .padding(start = 6.dp, end = 6.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        item {
            IconButton(onClick = {
                navController.navigate("home")
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }
        item{
            RecipeTitle(
                recipe,
                text = " ${recipe.name} recipe",
                fontSize = 26.sp
            )
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
                    .padding(top = 18 .dp),
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
        itemsIndexed(recipe.ingredients){ index, ingredient ->
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
        itemsIndexed(recipe.instructions){ index, instruction ->

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
