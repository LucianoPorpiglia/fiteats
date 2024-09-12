package com.app.fiteats.widget.button

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.fiteats.ui.theme.poppinsFontFamily

@Composable
fun FirstButton(
    modifier: Modifier,
    @StringRes textId: Int,
    onClick: () -> Unit
) {
    CustomButton(
        modifier = modifier,
        color = Color(0xFFe5e5e5),
        cornerRadius = 5.dp,
        onClick = onClick,
        textId = textId,
        textStyle = TextStyle(
            color = Color(0xFF266F58),
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        )
    )
}