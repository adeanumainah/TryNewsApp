package com.dean.trynewsapp.di

import com.dean.trynewsapp.data.source.ApiService
import com.dean.trynewsapp.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.Provider
import javax.inject.Singleton


//buat mengatur function2 apa aja yg mau di provide via dagger hilt,
//karena kita udh meninjek si api ke dalam repository,
//repository ke model
//api service butuh konfigurasi retrofit,
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides

    fun provideApi(): ApiService{
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }
}