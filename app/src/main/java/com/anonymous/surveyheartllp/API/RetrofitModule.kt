package com.anonymous.surveyheartllp.API

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://dummyjson.com") // Replace with your actual base URL
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    @Provides
    fun providesApiInterface(retrofit: Retrofit): APIinterface {
        return retrofit.create(APIinterface::class.java)
    }
}





