package com.mvvm.androidarchitecturesample.store.data.repository

import arrow.core.Either
import com.mvvm.androidarchitecturesample.store.data.maper.toGeneralError
import com.mvvm.androidarchitecturesample.store.data.remote.ProductsApi
import com.mvvm.androidarchitecturesample.store.domain.model.NetworkError
import com.mvvm.androidarchitecturesample.store.domain.model.Product
import com.mvvm.androidarchitecturesample.store.domain.repository.ProductsRepository
import javax.inject.Inject


class ProductsRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi
) : ProductsRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productsApi.getProducts()
        }.mapLeft { it.toGeneralError() }
    }
}