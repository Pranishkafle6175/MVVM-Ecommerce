package com.example.mvvm.domain.repository

import arrow.core.Either
import com.example.mvvm.domain.model.NetworkError
import com.example.mvvm.domain.model.Products

interface ProductsRepository {

    suspend fun getProducts(): Either<NetworkError, List<Products>>

}