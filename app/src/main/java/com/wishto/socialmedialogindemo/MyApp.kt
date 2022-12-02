package com.wishto.socialmedialogindemo

import android.app.Application
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //  AppEventsLogger.activateApp(this)
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}