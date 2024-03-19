package com.mvvm.androidarchitecturesample.store.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvvm.androidarchitecturesample.util.EventBus
import kotlinx.coroutines.launch


//This function is written as a extension function because to achieve encapsulation . I fwe have to modify any logic for event bus we can modify in
//the EventBus we dont have to change the implementation as this fucntion again calls the EventBus and same
//sendevent will be called
fun ViewModel.sendevent(event:Any){
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}
