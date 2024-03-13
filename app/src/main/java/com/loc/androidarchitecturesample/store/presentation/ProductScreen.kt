package com.loc.androidarchitecturesample.store.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.loc.androidarchitecturesample.store.presentation.components.LoadingDialog
import com.loc.androidarchitecturesample.store.presentation.util.TopAppBar

@Composable
internal fun ProductScreen(){

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductComponent(){

    LoadingDialog()
    Scaffold(
        topBar = { TopAppBar("Products") },
        modifier = Modifier.fillMaxSize()
    ){

    }
}