package com.example.seedbank

import android.app.Application
import android.util.Log
import com.example.seedbank.data.AppContainer
import com.example.seedbank.data.AppDataContainer

class SeedBankApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     * */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
        Log.d("SeedBankApplication", "SeedBankAPplication Initialized")
    }
}