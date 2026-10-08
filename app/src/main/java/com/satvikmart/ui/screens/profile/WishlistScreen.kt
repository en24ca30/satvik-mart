package com.satvikmart.ui.screens.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.satvikmart.ui.navigation.NavDestinations
import com.satvikmart.ui.screens.home.BottomNavBar

@Composable
fun ProfileScreen(navController: NavController) {
    val items = listOf(
        "Orders" to NavDestinations.ORDER_HISTORY,
        "Wishlist" to NavDestinations.WISHLIST,
        "Saved Addresses" to NavDestinations.ADDRESS_SELECTION,
        "Notifications" to NavDestinations.NOTIFICATIONS,
        "Settings" to NavDestinations.SETTINGS
    )

    Scaffold(topBar = { TopAppBar(title = { Text("Profile") }) }, bottomBar = { BottomNavBar(navController) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            item {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.padding(16.dp)) {
                        Text("Demo User\n9999999999\ndemo@satvikmart.com")
                    }
                }
            }
            items(items.size) { idx ->
                val (label, route) = items[idx]
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { navController.navigate(route) }) {
                    Box(modifier = Modifier.padding(16.dp)) { Text(label) }
                }
            }
        }
    }
}
