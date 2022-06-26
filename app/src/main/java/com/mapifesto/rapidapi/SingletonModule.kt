package com.mapifesto.rapidapi

import com.mapifesto.datasource_trueway.RapidIntermediary
import com.mapifesto.datasource_trueway.RapidIntermediaryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Singleton
    @Provides
    fun provideOsmIntermediary(

    ) : RapidIntermediary {
        return RapidIntermediaryImpl()
    }

}