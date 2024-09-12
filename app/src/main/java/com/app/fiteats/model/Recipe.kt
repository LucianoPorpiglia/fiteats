package com.app.fiteats.model

data class Recipe(
    val name: String,
    val imageUrl: String,
    val category: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val kcal: Int,
    val estimatedTime: Int,
    val estimatedCost: Double,
    val servings: Int
)
