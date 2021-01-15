package com.carbit3333333.cocktail_db.di.module

import androidx.multidex.BuildConfig
import com.carbit3333333.cocktail_db.repository.server.CocktailApi
import com.carbit3333333.cocktail_db.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
@Module
class ApiModule {
    companion object{
        const val BASE_IMAGE_URL = "https://www.thecocktaildb.com/images/media/drink/"
        private val API_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
    }
    @Provides
    @Singleton
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit{
        return builder.baseUrl(API_URL).build()
    }
    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder{
        val builder = OkHttpClient.Builder()
            .connectionPool(ConnectionPool(5, 30, TimeUnit.SECONDS))
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG){
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(httpLoggingInterceptor)
        }
        return Retrofit.Builder().client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): CocktailApi{
        return retrofit.create<CocktailApi>(CocktailApi::class.java!!)
    }
    @Provides
    @Singleton
    fun provideCommunicator(apiService: CocktailApi): ServerCommunicator {
        return ServerCommunicator(apiService)
    }
}