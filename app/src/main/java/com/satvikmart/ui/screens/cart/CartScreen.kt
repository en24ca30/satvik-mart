package com.satvikmart.ui.screens.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.satvikmart.ui.navigation.NavDestinations

@Composable
fun ProductDetailsScreen(navController: NavController, productId: String) {
    val scroll = rememberScrollState()
    Scaffold(topBar = { TopAppBar(title = { Text("Product details") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp).verticalScroll(scroll), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Box(modifier = Modifier.fillMaxWidth().height(220.dp).background(MaterialTheme.colorScheme.primaryContainer), contentAlignment = Alignment.Center) {
                Text("Product Image")
            }
            Text("Fresh Tomatoes", style = MaterialTheme.typography.headlineMedium)
            Text("Brand: Satvik Mart")
            Text("Weight: 1 kg")
            Text("MRP: ₹50")
            Text("Sale Price: ₹42")
            Text("Discount: 16%")
            Text("Rating: 4.4 ★ (180 reviews)")
            Text("Delivery in 15–30 minutes")
            Text("Fresh, hygienic tomatoes sourced for daily cooking needs.")

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(onClick = { navController.navigate(NavDestinations.CART) }) { Text("Add to Cart") }
                OutlinedButton(onClick = { navController.navigate(NavDestinations.CHECKOUT) }) { Text("Buy Now") }
            }

            Text("Similar products", style = MaterialTheme.typography.headlineSmall)
            repeat(3) {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Text("Similar Product", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
