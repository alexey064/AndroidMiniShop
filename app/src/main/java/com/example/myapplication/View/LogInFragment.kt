package com.example.myapplication.View

import com.example.myapplication.NetworkService.Companion.instance
import androidx.navigation.Navigation.findNavController
import android.widget.EditText
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.example.myapplication.R
import Models.LoginData
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.myapplication.ViewModel.LoginViewModel
import com.example.myapplication.databinding.FragmentLoginBinding
import kotlinx.coroutines.GlobalScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.coroutines.launch
import java.util.HashMap

class LogInFragment : Fragment() {
    var binding: FragmentLoginBinding?=null
    lateinit var LoginEdit: EditText
    lateinit var PasswordEdit: EditText
    val viewmodel by viewModel<LoginViewModel>()
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
        GlobalScope.launch {
            if (viewmodel.LoginButtonClick(SignData))
            {
                Navigation.findNavController(view).navigate(R.id.mainPageFragment)
            }
            else
            {
                Toast.makeText(context, R.string.WrongLoginPassword, Toast.LENGTH_SHORT).show()
            }
        }

    }
}