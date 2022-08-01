package com.example.myapplication.Adapter

import Models.LoginData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.NetworkService
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.HashMap

class AccountViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class RegistrationPageVH(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var EmailEdit : EditText
        var nameEdit : EditText
        var passwordEdit : EditText
        var confPasswordEdit : EditText
        var registerButton : Button
        init{
            EmailEdit = itemView.findViewById(R.id.regEmailEdit)
            nameEdit = itemView.findViewById(R.id.regNameEdit)
            passwordEdit = itemView.findViewById(R.id.regPasswordEdit)
            confPasswordEdit =itemView.findViewById(R.id.regConfPasswordEdit)
            registerButton = itemView.findViewById(R.id.regButton)
        }
    }

    class LogInPageVH(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var LoginButton : Button
        var LogInEdit : EditText
        var PasswordEdit : EditText
        init{
            LoginButton = itemView.findViewById<Button>(R.id.LogInButton)
            LogInEdit = itemView.findViewById(R.id.LogInEdit)
            PasswordEdit = itemView.findViewById(R.id.PasswordEdit)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            0 ->
            {
                return RegistrationPageVH(LayoutInflater.from(parent.context).inflate(R.layout.fr_reg, parent, false))
            }
            1 ->
            {
                return LogInPageVH(LayoutInflater.from(parent.context).inflate(R.layout.fr_login, parent, false))
            }
        }
        return RegistrationPageVH(
            LayoutInflater.from(parent.context).inflate(R.layout.fr_reg, parent, false))
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when(holder.itemViewType){
           0 ->
           {
               //REGISTRATION

               var hold : RegistrationPageVH = holder as RegistrationPageVH
               hold.registerButton.setOnClickListener { view ->
                   val login = hold.nameEdit.text.toString()
                   val password = hold.passwordEdit.text.toString()
                   if (hold.passwordEdit.text== hold.confPasswordEdit.text)
                   {
                       val RegData = HashMap<String, String>()
                       RegData["Username"] = login
                       RegData["Password"] = password
                       CoroutineScope(Dispatchers.IO).launch {
                           var response = NetworkService.instance!!.api.SignIn(RegData)
                           if (response!!.isSuccessful) {
                               LoginData.setUsername(hold.nameEdit.text.toString())
                               LoginData.setPassword(hold.passwordEdit.text.toString())
                               NetworkService.instance!!.getAuthorizeInstance(response.body()!!)
                               LoginData.setToken(response.body())
                               Navigation.findNavController(view).navigate(R.id.mainPageFragment)
                           } else {
                               Toast.makeText(hold.itemView.context, R.string.UserExists, Toast.LENGTH_SHORT)
                                   .show()
                           }
                       }
                   }
               }
           }
           1 ->
           {
               //LOGIN

               var hold : LogInPageVH = holder as LogInPageVH
               hold.LoginButton.setOnClickListener { view ->
                   val login = hold.LogInEdit.text.toString()
                   val password = hold.PasswordEdit.text.toString()
                   val SignData = HashMap<String, String>()
                   SignData["Username"] = login
                   SignData["Password"] = password
                   CoroutineScope(Dispatchers.IO).launch {
                       var response = NetworkService.instance!!.api.SignIn(SignData)
                       if (response!!.isSuccessful) {
                           LoginData.setUsername(hold.LogInEdit.text.toString())
                           LoginData.setPassword(hold.PasswordEdit.text.toString())
                           NetworkService.instance!!.getAuthorizeInstance(response.body()!!)
                           LoginData.setToken(response.body())
                           Navigation.findNavController(view).navigate(R.id.mainPageFragment)
                       } else {
                           Toast.makeText(hold.itemView.context, R.string.WrongLoginPassword, Toast.LENGTH_SHORT)
                               .show()
                       }
                   }
               }
           }
       }
    }
}