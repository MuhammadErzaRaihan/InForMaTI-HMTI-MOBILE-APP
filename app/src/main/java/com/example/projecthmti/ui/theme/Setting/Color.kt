package com.example.projecthmti.ui.theme.Setting

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light Colors
val PrimaryBlueLight = Color(0xFF3FD0FF)
val SecondaryBlueLight = Color(0xFF00C5FD)
val LightBlueLight = Color(0xFF96D3E3)

val WhiteLight = Color(0xFFFFFFFF)
val LightGrayLight = Color(0xFFD3D3D3)
val GrayLight = Color(0xFF808080)
val DarkGrayLight = Color(0xFFA9A9A9)
val BlackLight = Color(0xFF000000)

// Dark Colors (hanya background yang berubah)
val PrimaryBlueDark = Color(0xFF3FD0FF)
val SecondaryBlueDark = Color(0xFF00C5FD)
val LightBlueDark = Color(0xFF96D3E3)

val WhiteDark = Color(0xFF000000)
val LightGrayDark = Color(0xFFD3D3D3)
val GrayDark = Color(0xFF808080)
val DarkGrayDark = Color(0xFFA9A9A9)
val BlackDark = Color(0xFFFFFFFF)

val TransparentBlack = Color(0x80000000)

object AppColors {
    val primaryBlue: Color @Composable get() = if (isSystemInDarkTheme()) PrimaryBlueDark else PrimaryBlueLight
    val secondaryBlue: Color @Composable get() = if (isSystemInDarkTheme()) SecondaryBlueDark else SecondaryBlueLight
    val lightBlue: Color @Composable get() = if (isSystemInDarkTheme()) LightBlueDark else LightBlueLight

    val background: Color @Composable get() = if (isSystemInDarkTheme()) WhiteDark else WhiteLight
    val textPrimary: Color @Composable get() = if (isSystemInDarkTheme()) BlackDark else BlackLight
    val textSecondary: Color @Composable get() = if (isSystemInDarkTheme()) GrayDark else GrayLight

}