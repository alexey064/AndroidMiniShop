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
import com.example.myapplication.ViewModel.WirelessHeadphonesViewModel;
import com.example.myapplication.databinding.FragmentWirelessheadphonesBinding;

import java.util.ArrayList;

import Models.linked.Product;

public class WirelessHeadphonesFragment extends Fragment {

    private FragmentWirelessheadphonesBinding binding;
    RecyclerView WirelessHeadphonesRecView;
    WirelessHeadphonesViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWirelessheadphonesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        WirelessHeadphonesRecView = binding.WirelessRecView;
        VerticalSpacesItemDecoration SpacesItemDecoration = new VerticalSpacesItemDecoration(15);
        WirelessHeadphonesRecView.addItemDecoration(SpacesItemDecoration);
        viewModel = new ViewModelProvider(this).get(WirelessHeadphonesViewModel.class);
        viewModel.getWirelessHeadphonesLiveData().observe((LifecycleOwner) getContext(), updateWirelessHeadphones);
        return root;
    }

    Observer<ArrayList<Product>> updateWirelessHeadphones = new Observer<ArrayList<Product>>() {
        @Override
        public void onChanged(ArrayList<Product> products) {
          CatalogAdapter adapter = new CatalogAdapter(products);
          WirelessHeadphonesRecView.setAdapter(adapter);
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}