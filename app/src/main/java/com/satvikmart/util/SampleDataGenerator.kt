package com.satvikmart.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("satvikmart_prefs")

class AppPreferences(private val context: Context) {
    private val isLoggedInKey = booleanPreferencesKey("is_logged_in")

    val isLoggedIn: Flow<Boolean> = context.dataStore.data.map { it[isLoggedInKey] ?: false }

    suspend fun setLoggedIn(value: Boolean) {
        context.dataStore.edit { it[isLoggedInKey] = value }
    }
}
