package com.example.projecthmti.ui.theme.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projecthmti.ui.component.Header
import com.example.projecthmti.ui.components.BottomNavBar
import com.example.projecthmti.ui.theme.component.UpcomingEventSection
import com.example.projecthmti.ui.theme.component.Announcement
import com.example.projecthmti.ui.theme.component.MenuDivisiSection
import com.example.projecthmti.ui.theme.component.ProfileSidebar

@Preview
@Composable
fun HomeScreen(
    onLogout: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
    onNavigateToSettings: () -> Unit = {},
    onNavigateToSchedule: () -> Unit = {}
) {
    var selectedIndex by remember { mutableStateOf(0) }
    var showProfileSidebar by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { Header(onProfileClick = { showProfileSidebar = true }) },
        bottomBar = { BottomNavBar(selectedIndex = selectedIndex) { selectedIndex = it } }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            MainContent(
                showProfileSidebar = showProfileSidebar,
                onNavigateToProfile = onNavigateToProfile,
                onNavigateToSettings = onNavigateToSettings,
                onNavigateToSchedule = onNavigateToSchedule,
                onLogout = onLogout,
                selectedIndex = selectedIndex
            )

            ProfileSidebar(
                isVisible = showProfileSidebar,
                onDismiss = { showProfileSidebar = false },
                onProfileClick = {
                    showProfileSidebar = false
                    onNavigateToProfile()
                },
                onSettingsClick = {
                    showProfileSidebar = false
                    onNavigateToSettings()
                },
                onLogoutClick = {
                    showProfileSidebar = false
                    onLogout()
                }
            )
        }
    }
}

@Composable
fun MainContent(
    showProfileSidebar: Boolean,
    onNavigateToProfile: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onLogout: () -> Unit,
    onNavigateToSchedule: () -> Unit,
    selectedIndex: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        when (selectedIndex) {
            0 -> {
                Announcement()
                MenuDivisiSection()
                UpcomingEventSection(onAddScheduleClick = onNavigateToSchedule)
                Spacer(modifier = Modifier.height(80.dp))
            }
            1 -> {
                OnlineMemberList()
                Spacer(modifier = Modifier.height(80.dp))
            }
            3 -> NotifScreen()
            else -> {
                //  incase ada konten lain
            }
        }
    }
}

