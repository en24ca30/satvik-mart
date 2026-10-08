package com.satvikmart

import android.app.Application
import com.satvikmart.data.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SatvikMartApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            val db = AppDatabase.getInstance(this@SatvikMartApplication)
            db.seedDatabase()
        }
    }
}
