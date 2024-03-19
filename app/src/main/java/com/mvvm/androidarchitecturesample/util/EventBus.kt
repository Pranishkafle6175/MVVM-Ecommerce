package com.mvvm.androidarchitecturesample.util

import android.widget.Toast
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object EventBus {

//    TO send and receive event a channel has to be created and through that channel we send and receive different event
//    like toast Log etc.

    private val _events = Channel<Any>()

    // This creates a read only state which is used top receive data not update
    val events = _events.receiveAsFlow()

    suspend fun sendEvent(event:Any){
        _events.send(event)
    }

}

sealed interface Event{
    data class Toast(val message:String): Event
}