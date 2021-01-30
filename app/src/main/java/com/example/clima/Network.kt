package com.example.clima

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity

class Network {
    companion object {
        fun hayred(activity: AppCompatActivity):Boolean{
            val connectivityManager=activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val network =connectivityManager.activeNetworkInfo
            return network != null && network.isConnected
        }
    }
}