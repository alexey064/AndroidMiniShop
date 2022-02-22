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
import com.example.myapplication.ViewModel.WireHeadphonesViewModel;
import com.example.myapplication.databinding.FragmentWireheadphonesBinding;
import java.util.ArrayList;

import Models.linked.Product;

public class WireHeadphonesFragment extends Fragment implements LifecycleOwner {

    private FragmentWireheadphonesBinding binding;
    RecyclerView WireHeadphoneRecView;
    WireHeadphonesViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWireheadphonesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        WireHeadphoneRecView = binding.WireRecView;

        VerticalSpacesItemDecoration SpacesItemDecoration = new VerticalSpacesItemDecoration(15);
        WireHeadphoneRecView.addItemDecoration(SpacesItemDecoration);

        viewModel = new ViewModelProvider(this).get(WireHeadphonesViewModel.class);
        viewModel.getUserMutableLiveData().observe((LifecycleOwner) getContext(), updateWireHeadphones);

        return root;
    }
    Observer<ArrayList<Product>> updateWireHeadphones = new Observer<ArrayList<Product>>() {
        @Override
        public void onChanged(ArrayList<Product> products) {
            CatalogAdapter ProductAdapter = new CatalogAdapter(products);
            WireHeadphoneRecView.setAdapter(ProductAdapter);
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}