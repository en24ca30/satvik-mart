package com.satvikmart.ui.screens.category

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

@Composable
fun CategoryDetailScreen(navController: NavController, categoryId: String) {
    Scaffold(topBar = { TopAppBar(title = { Text(categoryId) }) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding)) {
            items(6) { index ->
                Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp).clickable { navController.navigate("${NavDestinations.PRODUCT_DETAILS}/p${index+1}") }) {
                    Box(modifier = Modifier.padding(18.dp)) {
                        Text("Product ${index + 1}")
                    }
                }
            }
        }
    }
}
