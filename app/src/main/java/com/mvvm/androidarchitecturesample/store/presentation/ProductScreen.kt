package com.mvvm.androidarchitecturesample.store.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mvvm.androidarchitecturesample.store.presentation.components.LoadingDialog
import com.mvvm.androidarchitecturesample.store.presentation.components.ProductCard
import com.mvvm.androidarchitecturesample.store.presentation.util.TopAppBar

@Composable
internal fun ProductScreen(){
    val viewModel: ProductsViewModel= hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    ProductComponent(state = state)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductComponent(
    state: ProductsViewState
){

    LoadingDialog()
    Scaffold(
        topBar = { TopAppBar("Products") },
        modifier = Modifier.fillMaxSize()
    ){
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(200.dp),
            verticalItemSpacing = 6.dp,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            content ={
                items(state.products) { product ->
                    ProductCard(product = product)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}