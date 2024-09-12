package com.app.fiteats.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.GoogleFont.Provider
import com.app.fiteats.R

val poppinsFontFamily = FontFamily(
    Font(resId = R.font.poppins_regular, weight = FontWeight.Normal),
    Font(resId = R.font.poppins_bold, weight = FontWeight.Bold),
    Font(resId = R.font.poppins_light, weight = FontWeight.Light),
    Font(resId = R.font.poppins_medium, weight = FontWeight.Medium),
)

//val Typography2 = Typography(
//    body1 = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    ),
//    h1 = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Bold,
//        fontSize = 30.sp
//    ),
//    button = TextStyle(
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.Medium,
//        fontSize = 14.sp
//    )
//)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        //fontFamily = FontFamily.Default,
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)