package com.satvikmart.ui.screens.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
fun UPIQRScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("DEMO UPI PAYMENT") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("UPI ID: quickcartdemo@upi")
            Text("Amount: ₹470")
            Text("Order ID: SM123456")
            Box(modifier = Modifier.size(220.dp), contentAlignment = Alignment.Center) { Text("QR CODE") }
            Button(onClick = { navController.navigate(NavDestinations.ORDER_CONFIRMATION) }, modifier = Modifier.fillMaxWidth()) { Text("I've completed payment") }
            OutlinedButton(onClick = { navController.popBackStack() }, modifier = Modifier.fillMaxWidth()) { Text("Cancel") }
        }
    }
}
