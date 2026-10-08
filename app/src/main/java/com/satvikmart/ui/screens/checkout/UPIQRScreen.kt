package com.satvikmart.ui.screens.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
fun PaymentMethodScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Payment Method") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Card(modifier = Modifier.fillMaxWidth()) { Box(modifier = Modifier.padding(16.dp)) { Text("UPI") } }
            Card(modifier = Modifier.fillMaxWidth()) { Box(modifier = Modifier.padding(16.dp)) { Text("UPI QR") } }
            Card(modifier = Modifier.fillMaxWidth()) { Box(modifier = Modifier.padding(16.dp)) { Text("Cash on Delivery") } }
            Button(onClick = { navController.navigate(NavDestinations.UPI_QR) }, modifier = Modifier.fillMaxWidth()) { Text("Select UPI QR") }
            OutlinedButton(onClick = { navController.navigate(NavDestinations.ORDER_CONFIRMATION) }, modifier = Modifier.fillMaxWidth()) { Text("Cash on Delivery") }
        }
    }
}
