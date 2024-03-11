package com.example.mvvm.domain.model

data class NetworkError(
    val error:ApiError,
    val t: Throwable?=null
)

enum class ApiError(val message :String){

//    This parameter is used to initialize the message property of the ApiError enum class.
//     you can refer to ApiError.NetworkError to represent a network error with the message "Network error".
    NetworkError("Network Error"),
    UnknownResponse("UnknownResponse"),
    UnknownError("Unknown Error")
}
