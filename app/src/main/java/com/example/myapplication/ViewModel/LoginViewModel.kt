package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.UseCase.LoginUseCase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.async
import java.util.HashMap

class LoginViewModel(_LoginUseCase : LoginUseCase) : ViewModel() {
    val Login: LoginUseCase
    init{
        Login=_LoginUseCase
    }
    suspend fun LoginButtonClick(LogInData:HashMap<String, String>) : Boolean
    {
        var result: Boolean = GlobalScope.async{
            Login.Execute(LogInData)
        }.await()
        return result
    }
}