package com.satvikmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.satvikmart.ui.navigation.NavDestinations
import com.satvikmart.ui.screens.auth.LoginScreen
import com.satvikmart.ui.screens.auth.OTPScreen
import com.satvikmart.ui.screens.auth.SplashScreen
import com.satvikmart.ui.screens.cart.CartScreen
import com.satvikmart.ui.screens.category.CategoryDetailScreen
import com.satvikmart.ui.screens.category.CategoryScreen
import com.satvikmart.ui.screens.checkout.AddAddressScreen
import com.satvikmart.ui.screens.checkout.AddressSelectionScreen
import com.satvikmart.ui.screens.checkout.CheckoutScreen
import com.satvikmart.ui.screens.checkout.PaymentMethodScreen
import com.satvikmart.ui.screens.checkout.UPIQRScreen
import com.satvikmart.ui.screens.home.HomeScreen
import com.satvikmart.ui.screens.order.OrderConfirmationScreen
import com.satvikmart.ui.screens.order.OrderHistoryScreen
import com.satvikmart.ui.screens.order.OrderTrackingScreen
import com.satvikmart.ui.screens.product.ProductDetailsScreen
import com.satvikmart.ui.screens.profile.NotificationsScreen
import com.satvikmart.ui.screens.profile.ProfileScreen
import com.satvikmart.ui.screens.profile.SettingsScreen
import com.satvikmart.ui.screens.profile.WishlistScreen
import com.satvikmart.ui.screens.search.SearchScreen
import com.satvikmart.ui.theme.SatvikMartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SatvikMartTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SatvikMartApp()
                }
            }
        }
    }
}

@Composable
fun SatvikMartApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavDestinations.SPLASH) {
        composable(NavDestinations.SPLASH) { SplashScreen(navController) }
        composable(NavDestinations.LOGIN) { LoginScreen(navController) }
        composable(NavDestinations.OTP) { OTPScreen(navController) }
        composable(NavDestinations.HOME) { HomeScreen(navController) }
        composable(NavDestinations.CATEGORIES) { CategoryScreen(navController) }
        composable("${NavDestinations.CATEGORY_DETAIL}/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId") ?: ""
            CategoryDetailScreen(navController, categoryId)
        }
        composable(NavDestinations.SEARCH) { SearchScreen(navController) }
        composable("${NavDestinations.PRODUCT_DETAILS}/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailsScreen(navController, productId)
        }
        composable(NavDestinations.CART) { CartScreen(navController) }
        composable(NavDestinations.CHECKOUT) { CheckoutScreen(navController) }
        composable(NavDestinations.ADDRESS_SELECTION) { AddressSelectionScreen(navController) }
        composable(NavDestinations.ADD_ADDRESS) { AddAddressScreen(navController) }
        composable(NavDestinations.PAYMENT_METHOD) { PaymentMethodScreen(navController) }
        composable(NavDestinations.UPI_QR) { UPIQRScreen(navController) }
        composable(NavDestinations.ORDER_CONFIRMATION) { OrderConfirmationScreen(navController) }
        composable(NavDestinations.ORDER_TRACKING) { OrderTrackingScreen(navController) }
        composable(NavDestinations.ORDER_HISTORY) { OrderHistoryScreen(navController) }
        composable(NavDestinations.PROFILE) { ProfileScreen(navController) }
        composable(NavDestinations.WISHLIST) { WishlistScreen(navController) }
        composable(NavDestinations.NOTIFICATIONS) { NotificationsScreen(navController) }
        composable(NavDestinations.SETTINGS) { SettingsScreen(navController) }
    }
}
