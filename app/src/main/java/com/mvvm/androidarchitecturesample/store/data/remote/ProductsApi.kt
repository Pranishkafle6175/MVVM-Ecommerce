package com.mvvm.androidarchitecturesample.store.data.remote

import com.mvvm.androidarchitecturesample.store.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(): List<Product>

}