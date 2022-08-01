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
import com.example.myapplication.Adapter.AccountViewAdapter
import com.example.myapplication.NetworkService
import com.example.myapplication.ViewModel.AccountViewModel
import com.example.myapplication.databinding.FragmentAccountBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.HashMap
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountFragment : Fragment() {
    private var binding: FragmentAccountBinding? = null
    private var LoginEdit: EditText? = null
    private var PasswordEdit: EditText? = null
    val viewModel : AccountViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountBinding.inflate(inflater, container, false)
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
        CoroutineScope(Dispatchers.IO).launch {
            var response = NetworkService.instance!!.api.SignIn(SignData)
            if (response!!.isSuccessful)
            {
                LoginData.setUsername(LoginEdit!!.text.toString())
                LoginData.setPassword(PasswordEdit!!.text.toString())
                instance!!.getAuthorizeInstance(response.body()!!)
                LoginData.setToken(response.body())
                Navigation.findNavController(view).navigate(R.id.mainPageFragment)
            }
            else
            {
                Toast.makeText(context, R.string.WrongLoginPassword, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

/*
private var binding: FragmentLoginBinding? = null
    private var LoginEdit: EditText? = null
    private var PasswordEdit: EditText? = null
    val viewModel : AccountViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
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
 */