package com.camilorubio.robin.data

sealed class ResponseState {
    class Success(val data: Any) : ResponseState()
    class Error(val message: Any) : ResponseState()
}