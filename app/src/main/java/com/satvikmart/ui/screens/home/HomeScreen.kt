package com.satvikmart.ui.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.satvikmart.ui.navigation.NavDestinations

@Composable
fun OTPScreen(navController: NavController) {
    var otp by remember { mutableStateOf("123456") }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Verify OTP", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = otp, onValueChange = { otp = it }, label = { Text("Enter OTP") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate(NavDestinations.HOME) {
                popUpTo(NavDestinations.LOGIN) { inclusive = true }
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Verify & Continue")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("Demo OTP: 123456")
    }
}
