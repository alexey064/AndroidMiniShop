package com.example.myapplication.View;

import android.os.Bundle;
import android.util.Log;
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
import com.example.myapplication.ViewModel.SmartphoneViewModel;
import com.example.myapplication.databinding.FragmentSmartphonesBinding;

import java.util.ArrayList;
import java.util.Date;

import Models.linked.Product;

public class SmartphonesFragment extends Fragment implements LifecycleOwner {

    private FragmentSmartphonesBinding binding;
    private RecyclerView SmartphoneRecView;
    private ArrayList<Product> products;
    SmartphoneViewModel viewModel;
    CatalogAdapter Adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSmartphonesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SmartphoneRecView = binding.SmartphoneRecView;
        VerticalSpacesItemDecoration SpacesItemDecoration = new VerticalSpacesItemDecoration(15);
        SmartphoneRecView.addItemDecoration(SpacesItemDecoration);

        viewModel = new ViewModelProvider(this).get(SmartphoneViewModel.class);
        viewModel.getUserMutableLiveData().observe((LifecycleOwner) getContext(), userListUpdateObserver);


        return root;
    }
    Observer<ArrayList<Product>> userListUpdateObserver = new Observer<ArrayList<Product>>() {
        @Override
        public void onChanged(ArrayList<Product> userArrayList) {
            if (userArrayList.size()>0)
            {
                Adapter = new CatalogAdapter(userArrayList);
                SmartphoneRecView.setAdapter(Adapter);
                Date EndDate = new Date();
                Log.d("TIMER",String.valueOf(EndDate.getTime()));
            }
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

/*
        HttpApi model = new HttpApi();
        String result=null;
        try {

            result=model.Catalog(TYPE);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        ArrayList<Product> Products;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer());
        Gson gson = builder.create();
        Products= gson.fromJson(result, new TypeToken<ArrayList<Product>>(){}.getType());
 */