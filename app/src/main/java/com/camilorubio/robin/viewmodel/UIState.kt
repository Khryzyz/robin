package com.camilorubio.robin.viewmodel

sealed class UIState {
    class Success(val data: Any) : UIState()
    class Error(val message: Any) : UIState()
}