package com.example.myapplication.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.CartAdapter;
import com.example.myapplication.NetworkService;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.CartViewModel;
import com.example.myapplication.databinding.FragmentCartBinding;

import java.util.ArrayList;

import Models.linked.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class CartFragment extends Fragment implements View.OnClickListener{
    private FragmentCartBinding binding;
    RecyclerView CartRecView;
    CartViewModel viewModel;
    Button makeOrder;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        CartRecView = root.findViewById(R.id.CartList);
        makeOrder = root.findViewById(R.id.MakeOrder);
        makeOrder.setOnClickListener(this);
        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
        viewModel.GetCartLiveData().observe((LifecycleOwner) this, updateCartLiveData);
        return root;
    }
    Observer<ArrayList<Product>> updateCartLiveData = new Observer<ArrayList<Product>>() {
        @Override
        public void onChanged(ArrayList<Product> products) {
            int TotalPrice = 0;
            for (Product prod: products) {
                TotalPrice=TotalPrice+prod.getPrice();
            }
            makeOrder.setText(String.valueOf(TotalPrice));
            CartAdapter adapter = new CartAdapter(products);
            CartRecView.setAdapter(adapter);
        } };
    @Override
    public void onClick(View view) {
        NetworkService.getInstance().getApi().CompleteOrder().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Navigation.findNavController(view).navigate(R.id.CartFragment);
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });  }  }