package com.example.myapplication.View

import com.example.myapplication.NetworkService.Companion.instance
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.example.myapplication.R
import Models.LoginData
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class LogInFragment : Fragment() {
    private var binding: FragmentLoginBinding? = null
    private var LoginEdit: EditText? = null
    private var PasswordEdit: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        LoginEdit = root.findViewById(R.id.Login)
        PasswordEdit = root.findViewById(R.id.Password)
        val Login = root.findViewById<Button>(R.id.SignInTo)
        Login.setOnClickListener(LoginButton)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    var LoginButton = View.OnClickListener { view ->
        val login = LoginEdit!!.text.toString()
        val password = PasswordEdit!!.text.toString()
        val SignData = HashMap<String, String>()
        SignData["Username"] = login
        SignData["Password"] = password
        instance!!.api.SignIn(SignData)!!.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                LoginData.setUsername(LoginEdit!!.text.toString())
                LoginData.setPassword(PasswordEdit!!.text.toString())
                instance!!.getAuthorizeInstance(response.body()!!)
                LoginData.setToken(response.body())
                Navigation.findNavController(view).navigate(R.id.mainPageFragment)
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                Toast.makeText(context, R.string.WrongLoginPassword, Toast.LENGTH_SHORT).show()
            }
        })
    }
}