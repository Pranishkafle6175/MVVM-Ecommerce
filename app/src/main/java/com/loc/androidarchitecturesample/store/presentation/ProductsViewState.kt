package com.loc.androidarchitecturesample.store.presentation

import com.loc.androidarchitecturesample.store.domain.model.Product

data class ProductsViewState (
    var isLoading:Boolean=false,
    var products:List<Product> =emptyList(),
    var error:String?=null
        )