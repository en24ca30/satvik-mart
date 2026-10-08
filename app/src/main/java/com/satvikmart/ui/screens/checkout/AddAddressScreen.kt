package com.satvikmart.ui.screens.checkout

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

@Composable
fun AddressSelectionScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Select Address") }) }) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            item {
                Button(onClick = { navController.navigate(NavDestinations.ADD_ADDRESS) }, modifier = Modifier.fillMaxWidth()) {
                    Text("Add New Address")
                }
            }
            items(2) { index ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Text("Home Address ${index + 1}", modifier = Modifier.padding(16.dp))
                }
            }
            item {
                Button(onClick = { navController.navigate(NavDestinations.PAYMENT_METHOD) }, modifier = Modifier.fillMaxWidth()) {
                    Text("Continue")
                }
            }
        }
    }
}
