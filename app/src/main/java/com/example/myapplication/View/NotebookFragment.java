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
import com.example.myapplication.ViewModel.NotebookViewModel;
import com.example.myapplication.databinding.FragmentNotebookBinding;

import java.util.ArrayList;
import java.util.Date;

import Models.linked.Product;
public class NotebookFragment extends Fragment implements LifecycleOwner {
    private FragmentNotebookBinding binding;
    private NotebookViewModel viewModel;
    RecyclerView NotebookRecView;
    CatalogAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotebookBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        NotebookRecView = binding.NotebookRecView;
        VerticalSpacesItemDecoration SpacesItemDecoration = new VerticalSpacesItemDecoration(15);
        NotebookRecView.addItemDecoration(SpacesItemDecoration);
        viewModel = new ViewModelProvider(this).get(NotebookViewModel.class);
        viewModel.getUserMutableLiveData().observe((LifecycleOwner) getContext(), userListUpdateObserver);
        return root;
    }
    Observer<ArrayList<Product>> userListUpdateObserver = new Observer<ArrayList<Product>>() {
        @Override
        public void onChanged(ArrayList<Product> userArrayList) {
            adapter = new CatalogAdapter(userArrayList);
            NotebookRecView.setAdapter(adapter);
            Date EndDate = new Date();
            Log.d("TIMER",String.valueOf(EndDate.getTime()));
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}