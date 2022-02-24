package com.example.myapplication.UseCase

import Models.LoginData
import androidx.navigation.Navigation
import com.example.myapplication.NetworkService
import java.util.HashMap

class LoginUseCase {
    suspend fun Execute(LogInData: HashMap<String, String>): Boolean
    {
        val response = NetworkService.instance?.api?.SignIn(LogInData)
        if (response?.isSuccessful==true){
            LoginData.setUsername(LogInData["Username"])
            LoginData.setPassword(LogInData["Password"])
            NetworkService.instance!!.getAuthorizeInstance(response.body()!!)
            LoginData.setToken(response.body())
            return true
        }
        return false
    }
}