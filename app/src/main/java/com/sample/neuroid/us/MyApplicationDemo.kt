package com.sample.neuroid.us

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import androidx.multidex.MultiDexApplication
import com.neuroid.tracker.NeuroID

class MyApplicationDemo : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        StrictMode.setThreadPolicy(
            ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )
        StrictMode.setVmPolicy(
            VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .build()
        )
        val neuroId = NeuroID.Builder(
            this,
            "key_live_dNoyQAlq8w1c0mCeHKl5Sejl"
        ).build()
        NeuroID.setNeuroIdInstance(neuroId)
        NeuroID.getInstance()?.setEnvironment("TEST")
        NeuroID.getInstance()?.setSiteId("form_picks709")
        val rnds = (0..10000).random().toString()
        NeuroID.getInstance()?.setUserID(rnds)
        NeuroID.getInstance()?.start()
    }
}