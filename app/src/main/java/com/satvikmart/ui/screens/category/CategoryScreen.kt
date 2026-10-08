package com.satvikmart.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.satvikmart.ui.navigation.NavDestinations
import com.satvikmart.ui.theme.WarmCream

@Composable
fun HomeScreen(navController: NavController) {
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Satvik Mart") }) },
        bottomBar = { BottomNavBar(navController) }
    ) { padding ->
        LazyColumn( modifier = Modifier.fillMaxSize().padding(padding).background(WarmCream) ) {
            item {
                Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.LocationOn, contentDescription = null)
                            Text("Delivering to: Indore, MP")
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Get your essentials in 15–30 minutes")
                        Spacer(modifier = Modifier.height(12.dp))
                        OutlinedTextField(value = searchText, onValueChange = { searchText = it }, label = { Text("What are you looking for?") }, modifier = Modifier.fillMaxWidth())
                    }
                }
            }

            item {
                Text("Popular Categories", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(horizontal = 16.dp))
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.padding(horizontal = 16.dp)) {
                    items(listOf("Staples","Dal","Dairy","Herbal","Fruits","Vegetables","Pooja")) { item ->
                        Card(modifier = Modifier.clickable { navController.navigate(NavDestinations.CATEGORIES) }) {
                            Box(modifier = Modifier.padding(horizontal = 18.dp, vertical = 12.dp)) {
                                Text(item)
                            }
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(20.dp)) }
            item { Text("Recommended Products", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(horizontal = 16.dp)) }

            items(4) { index ->
                Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp).clickable { navController.navigate("${NavDestinations.PRODUCT_DETAILS}/p${index+1}") }) {
                    Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(90.dp).background(MaterialTheme.colorScheme.primaryContainer))
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Sample Product ${index+1}", style = MaterialTheme.typography.titleLarge)
                            Text("₹${(100 + index * 25)}")
                            Text("Delivery in 15–30 minutes")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavController) {
    NavigationBar {
        NavigationBarItem(selected = true, onClick = { navController.navigate(NavDestinations.HOME) }, icon = { Icon(Icons.Default.Home, contentDescription = null) }, label = { Text("Home") })
        NavigationBarItem(selected = false, onClick = { navController.navigate(NavDestinations.CATEGORIES) }, icon = { Icon(Icons.Default.Category, contentDescription = null) }, label = { Text("Categories") })
        NavigationBarItem(selected = false, onClick = { navController.navigate(NavDestinations.SEARCH) }, icon = { Icon(Icons.Default.Search, contentDescription = null) }, label = { Text("Search") })
        NavigationBarItem(selected = false, onClick = { navController.navigate(NavDestinations.CART) }, icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) }, label = { Text("Cart") })
        NavigationBarItem(selected = false, onClick = { navController.navigate(NavDestinations.PROFILE) }, icon = { Icon(Icons.Default.Person, contentDescription = null) }, label = { Text("Profile") })
    }
}
