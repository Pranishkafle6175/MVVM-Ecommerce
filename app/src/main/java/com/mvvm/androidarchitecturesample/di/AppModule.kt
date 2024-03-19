package com.mvvm.androidarchitecturesample.di

import com.mvvm.androidarchitecturesample.store.data.remote.ProductsApi
import com.mvvm.androidarchitecturesample.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideProductsApi(): ProductsApi{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsApi::class.java)



    }
}
