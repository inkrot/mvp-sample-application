package ru.simdelivery.mvpapplication.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import ru.simdelivery.mvpapplication.network.EchoWebSocketListener
import ru.simdelivery.mvpapplication.network.NetworkUtils

@Module
class NetworkModule {

    @Provides fun provideNetworkUtils(): NetworkUtils = NetworkUtils()
    @Provides fun provideOkHttpClient(): OkHttpClient = OkHttpClient()
    @Provides fun provideEchoWebSocketListener(): EchoWebSocketListener = EchoWebSocketListener()
}