package com.example.myapplication.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import Models.LoginData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentLoginBinding;

import java.util.HashMap;
public class LogInFragment  extends Fragment {
    /*private FragmentLoginBinding binding;
    private EditText LoginEdit;
    private EditText PasswordEdit;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        LoginEdit =root.findViewById(R.id.Login);
        PasswordEdit = root.findViewById(R.id.Password);
        Button Login = root.findViewById(R.id.SignInTo);
        Login.setOnClickListener(LoginButton);
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    View.OnClickListener LoginButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String login =LoginEdit.getText().toString();
            String password =PasswordEdit.getText().toString();
            HashMap<String, String> SignData = new HashMap<>();
            SignData.put("Username",login);
            SignData.put("Password",password);
            NetworkService.getInstance().getApi().SignIn(SignData).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    LoginData.setUsername(LoginEdit.getText().toString());
                    LoginData.setPassword(PasswordEdit.getText().toString());
                    NetworkService.getInstance().getAuthorizeInstance(response.body());
                    LoginData.setToken(response.body());
                    Navigation.findNavController(view).navigate(R.id.mainPageFragment);
                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(getContext(), R.string.WrongLoginPassword,Toast.LENGTH_SHORT).show();
                }
            });
        }
    };
     */
}