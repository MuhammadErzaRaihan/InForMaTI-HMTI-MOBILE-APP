package com.example.projecthmti

import androidx.compose.runtime.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.projecthmti.ui.theme.Screen.HomeScreen
import com.example.projecthmti.ui.theme.*
import com.example.projecthmti.ui.theme.Screen.LoginScreen
import com.example.projecthmti.ui.theme.Screen.ProfileDetailScreen
import com.example.projecthmti.ui.theme.Screen.RecoveryScreen
import com.example.projecthmti.ui.theme.Screen.RegistScreen
import com.example.projecthmti.ui.theme.Screen.ScheduleScreen
import com.example.projecthmti.ui.theme.Screen.SplashScreen
import com.example.projecthmti.ui.theme.Setting.AppSettings
import com.example.projecthmti.ui.theme.Setting.SettingScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var showSplash by remember { mutableStateOf(true) }
            var login by remember { mutableStateOf(false) }
            var regist by remember { mutableStateOf(false) }
            var recovery by remember { mutableStateOf(false) }
            var showProfile by remember { mutableStateOf(false) }
            var showSettings by remember { mutableStateOf(false) }
            var showSchedule by remember { mutableStateOf(false) }
            var appSettings by remember { mutableStateOf(AppSettings()) }

            ProjectHMTITheme(darkTheme = appSettings.isDarkMode) {
                when {
                    showSplash -> {
                        SplashScreen {
                            showSplash = false
                        }
                    }

                    regist -> {
                        RegistScreen(
                            onRegister = { _, _, _, _, _, _ ->
                                // nun, karena hanya preview UI
                            },
                            onLogin = {
                                regist = false
                            }
                        )
                    }


                    recovery -> {
                        RecoveryScreen(
                            onRecoverySubmitted = { email, oldPassword ->
                                recovery = false
                            },
                            onBackClick = { recovery = false }
                        )
                    }

                    showProfile -> {
                        ProfileDetailScreen(
                            onBackClick = { showProfile = false }
                        )
                    }


                    showSettings -> {
                        SettingScreen(
                            onBackClick = { showSettings = false },
                            initialSettings = appSettings,
                            onSettingsChanged = {
                                    newSettings -> appSettings = newSettings
                            }
                        )
                    }

                    showSchedule -> {
                        ScheduleScreen(
                            onBackClick = { showSchedule = false }
                        )
                    }
                    !login -> {
                        LoginScreen(
                            Succeed = { login = true },
                            onRecovery = { recovery = true },
                            onRegistClick = { regist = true }
                        )
                    }

                    else -> {
                        HomeScreen(
                            onLogout = { login = false },
                            onNavigateToProfile = { showProfile = true },
                            onNavigateToSettings = { showSettings = true },
                            onNavigateToSchedule = { showSchedule = true }
                        )
                    }
                }
            }
            }

    }


}