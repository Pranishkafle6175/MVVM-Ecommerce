package com.mvvm.androidarchitecturesample.store.domain.repository

import arrow.core.Either
import com.mvvm.androidarchitecturesample.store.domain.model.NetworkError
import com.mvvm.androidarchitecturesample.store.domain.model.Product

interface ProductsRepository {

    suspend fun getProducts(): Either<NetworkError, List<Product>>

}
