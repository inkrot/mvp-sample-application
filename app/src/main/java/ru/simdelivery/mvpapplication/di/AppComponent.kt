package ru.simdelivery.mvpapplication.di

import dagger.Component
import ru.simdelivery.mvpapplication.app.App
import ru.simdelivery.mvpapplication.app.LoginActivity


@Component(modules = [NetworkModule::class, StorageModule::class])
interface AppComponent {

    fun injectsApp(app: App)
    fun injectsLoginActivity(loginActivity: LoginActivity)
}