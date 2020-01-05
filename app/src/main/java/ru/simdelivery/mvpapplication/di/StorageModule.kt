package ru.simdelivery.mvpapplication.di

import dagger.Module
import dagger.Provides
import ru.simdelivery.mvpapplication.storage.DatabaseHelper

@Module
class StorageModule {

    @Provides fun provideDatabaseHelper(): DatabaseHelper = DatabaseHelper()
}