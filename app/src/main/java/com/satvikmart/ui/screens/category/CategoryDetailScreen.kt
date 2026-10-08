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
import com.satvikmart.ui.screens.home.BottomNavBar

@Composable
fun CategoryScreen(navController: NavController) {
    val categories = listOf(
        "Shuddh Atta & Staples",
        "Dal & Pulses",
        "Desi Ghee & Cooking Essentials",
        "Herbal & Ayurvedic Care",
        "Healthy Snacks",
        "Dairy Products",
        "Fresh Fruits",
        "Fresh Vegetables",
        "Pooja Samagri",
        "Festival Essentials",
        "Household Cleaning",
        "Hygiene & Personal Care"
    )

    Scaffold(topBar = { TopAppBar(title = { Text("Categories") }) }, bottomBar = { BottomNavBar(navController) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding)) {
            items(categories.size) { index ->
                Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp).clickable { navController.navigate("${NavDestinations.CATEGORY_DETAIL}/${categories[index]}") }) {
                    Box(modifier = Modifier.padding(18.dp)) {
                        Text(categories[index])
                    }
                }
            }
        }
    }
}
