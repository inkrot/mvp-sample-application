package ru.simdelivery.mvpapplication.app

import android.app.Application
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import ru.simdelivery.mvpapplication.di.AppComponent
import ru.simdelivery.mvpapplication.di.DaggerAppComponent
import ru.simdelivery.mvpapplication.network.EchoWebSocketListener
import javax.inject.Inject


class App: Application() {

    companion object {
        lateinit var component: AppComponent
    }

    @Inject
    lateinit var client: OkHttpClient

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.create()
        component.injectsApp(this)

        initSocketConnection()
    }

    private fun initSocketConnection() {
        val request: Request = Request.Builder().url("ws://simdelivery.ru:3001").build()
        val listener = EchoWebSocketListener()
        val ws: WebSocket = client.newWebSocket(request, listener)
        client.dispatcher().executorService().shutdown()
    }
}