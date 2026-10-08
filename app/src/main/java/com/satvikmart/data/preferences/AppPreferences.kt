package com.satvikmart.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppPreferences(context: Context) {
    private val dataStore: DataStore<Preferences> = context.dataStore

    companion object {
        private const val PREFERENCES_NAME = "satvik_mart_prefs"
        private val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        private val USER_MOBILE = stringPreferencesKey("user_mobile")
        private val USER_NAME = stringPreferencesKey("user_name")
        private val DEFAULT_ADDRESS_ID = stringPreferencesKey("default_address_id")
        private val SELECTED_COUPON = stringPreferencesKey("selected_coupon")
    }

    val isLoggedIn: Flow<Boolean> = dataStore.data.map { it[IS_LOGGED_IN] ?: false }
    val userMobile: Flow<String> = dataStore.data.map { it[USER_MOBILE] ?: "" }
    val userName: Flow<String> = dataStore.data.map { it[USER_NAME] ?: "" }
    val defaultAddressId: Flow<String> = dataStore.data.map { it[DEFAULT_ADDRESS_ID] ?: "" }
    val selectedCoupon: Flow<String> = dataStore.data.map { it[SELECTED_COUPON] ?: "" }

    suspend fun setLoggedIn(isLoggedIn: Boolean) {
        dataStore.edit { preferences -> preferences[IS_LOGGED_IN] = isLoggedIn }
    }

    suspend fun setUserMobile(mobile: String) {
        dataStore.edit { preferences -> preferences[USER_MOBILE] = mobile }
    }

    suspend fun setUserName(name: String) {
        dataStore.edit { preferences -> preferences[USER_NAME] = name }
    }

    suspend fun setDefaultAddressId(addressId: String) {
        dataStore.edit { preferences -> preferences[DEFAULT_ADDRESS_ID] = addressId }
    }

    suspend fun setSelectedCoupon(coupon: String) {
        dataStore.edit { preferences -> preferences[SELECTED_COUPON] = coupon }
    }

    suspend fun clear() {
        dataStore.edit { it.clear() }
    }
}

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "satvik_mart_prefs"
)
