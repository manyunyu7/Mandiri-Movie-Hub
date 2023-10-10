package com.feylabs.poke.di

import android.content.Context
import android.net.ConnectivityManager
import com.feylabs.poke.data.source.remote.service.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonModule {

    @Provides
    @Singleton
    @ConnectivityManagerSnips
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    @Singleton
    @RetrofitSnips
    fun providePokemonAPI(): PokemonApi {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    private fun provideOkHttpClient(apiKey: String): OkHttpClient {
        val interceptor = Interceptor { chain ->
            val originalRequest = chain.request()
            val originalHttpUrl = originalRequest.url

            // Append API key as a query parameter
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", apiKey)
                .build()

            val request = originalRequest.newBuilder()
                .url(url)
                .build()

            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class RetrofitSnips

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ConnectivityManagerSnips




}