package com.satvikmart.ui.screens.profile

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

@Composable
fun WishlistScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Wishlist") }) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            items(4) { index ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Text("Wishlist item ${index + 1}", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
