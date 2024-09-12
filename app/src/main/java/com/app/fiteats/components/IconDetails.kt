package com.app.fiteats.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconRow(
    painter: Painter,
    contentDescription: String,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
        .offset(y = ((-4).dp))
        .padding(horizontal = 2.dp),
    tint: Color = Color.Gray,
    size: Dp = 14.dp
) {
    Icon(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier.size(size),
        tint = tint
    )
}