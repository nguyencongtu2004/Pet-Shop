package com.example.petshop.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.petshop.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontWeight = FontWeight(500),
        //color = Color(0xFF3C3C3C),
    ),
    titleLarge = TextStyle(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontWeight = FontWeight(500),
        //color = Color(0xFF3C3C3C),
    ),
    titleSmall = TextStyle(
        fontSize = 12.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontWeight = FontWeight(500),
        //color = Color(0xFF3C3C3C),
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight(400),
        //color = Color(0xFF555555),
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        lineHeight = 20.sp,
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight(400),
        //color = Color(0xFF555555),
    )
)