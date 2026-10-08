package com.satvikmart.ui.screens.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
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
fun CartScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Cart") }) }, bottomBar = { BottomNavBar(navController) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            item { Text("Your Satvik Mart order can arrive in 15–30 minutes") }
            items(3) { index ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                    Text("Cart item ${index + 1}", modifier = Modifier.padding(16.dp))
                }
            }
            item {
                Text("Subtotal: ₹500")
                Text("Discount: ₹50")
                Text("Delivery: ₹20")
                Text("Final Amount: ₹470")
                Button(onClick = { navController.navigate(NavDestinations.CHECKOUT) }, modifier = Modifier.fillMaxWidth()) {
                    Text("Proceed to Checkout")
                }
            }
        }
    }
}
