package ru.simdelivery.mvpapplication.network

import android.util.Log

class NetworkUtils {

    fun request(url: String) {
        Log.d(this.javaClass.name, "Request to the server: " + url)
    }
}