package com.satvikmart.ui.screens.order

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

@Composable
fun OrderTrackingScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Track Order") }) }) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Order Number: SM123456")
            Text("Estimated Delivery: 20 minutes")
            Text("Status: Out for Delivery")
            Text("Delivery Rider: Satvik Rider")
            Text("Delivery Address: 24 Green Avenue, Indore")
            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) { Text("Contact Support") }
        }
    }
}
