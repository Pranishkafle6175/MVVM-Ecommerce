package com.mvvm.androidarchitecturesample.store.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvvm.androidarchitecturesample.store.domain.repository.ProductsRepository
import com.mvvm.androidarchitecturesample.util.Event
import com.mvvm.androidarchitecturesample.util.EventBus.sendEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
): ViewModel() {
    private val _state = MutableStateFlow(ProductsViewState())
    val state = _state.asStateFlow()

    init {
        getProducts()
    }

    fun getProducts() {
        _state.update {
            it.copy(isLoading = true)
        }

            viewModelScope.launch {
                productsRepository.getProducts()
                    .onRight { products ->
                        _state.update {
                            it.copy(products = products)
                        }
                    }
                    .onLeft { error ->
                        _state.update {
                            it.copy(error = error.error.message)
                        }
                        sendEvent(Event.Toast(error.error.message))
                    }
            }

        _state.update {
            it.copy(isLoading = false)
        }

    }
}