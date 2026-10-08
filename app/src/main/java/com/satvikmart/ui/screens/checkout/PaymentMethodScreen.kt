package com.satvikmart.ui.screens.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.satvikmart.ui.navigation.NavDestinations

@Composable
fun CheckoutScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Checkout") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Estimated delivery: 15–30 minutes")
            Text("Address: 24 Green Avenue, Indore")
            Text("Subtotal: ₹500")
            Text("Discount: ₹50")
            Text("Delivery: ₹20")
            Text("Total: ₹470")
            Button(onClick = { navController.navigate(NavDestinations.PAYMENT_METHOD) }, modifier = Modifier.fillMaxWidth()) {
                Text("Continue to Payment")
            }
        }
    }
}
