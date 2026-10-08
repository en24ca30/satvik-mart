package com.satvikmart.ui.screens.order

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.satvikmart.ui.navigation.NavDestinations

@Composable
fun OrderConfirmationScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Order Confirmed") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Order placed successfully!")
            Text("Order ID: SM123456")
            Text("Estimated delivery: 20 minutes")
            Button(onClick = { navController.navigate(NavDestinations.ORDER_TRACKING) }, modifier = Modifier.fillMaxWidth()) { Text("Track Order") }
            OutlinedButton(onClick = { navController.navigate(NavDestinations.HOME) }, modifier = Modifier.fillMaxWidth()) { Text("Continue Shopping") }
        }
    }
}
