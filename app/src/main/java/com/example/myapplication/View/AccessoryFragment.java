package com.example.myapplication.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.CatalogAdapter;
import com.example.myapplication.Other.VerticalSpacesItemDecoration;
import com.example.myapplication.ViewModel.AccessoryViewModel;
import com.example.myapplication.databinding.FragmentAccessoryBinding;

import java.util.ArrayList;

import Models.linked.Product;
public class AccessoryFragment extends Fragment {
    private FragmentAccessoryBinding binding;
    RecyclerView AccessoryRecView;
    AccessoryViewModel viewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAccessoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
         AccessoryRecView= binding.AccessoryRecView;
        VerticalSpacesItemDecoration SpacesItemDecoration = new VerticalSpacesItemDecoration(15);
        AccessoryRecView.addItemDecoration(SpacesItemDecoration);
        viewModel= new ViewModelProvider(this).get(AccessoryViewModel.class);
        viewModel.getAccessoryLiveData().observe((LifecycleOwner) this, updateAccessoryList);
        return root;
    }
    Observer<ArrayList<Product>> updateAccessoryList = new Observer<ArrayList<Product>>() {
        @Override
        public void onChanged(ArrayList<Product> products) {
            CatalogAdapter adapter = new CatalogAdapter(products);
            AccessoryRecView.setAdapter(adapter);
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}