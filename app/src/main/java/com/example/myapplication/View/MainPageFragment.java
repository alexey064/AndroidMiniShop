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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Models.ViewModel.*;

public class MainPageFragment extends Fragment {
    /*private FragmentMainPageBinding binding;
    RecyclerView _NewlyAdded;
    RecyclerView _MostBuyed;
    RecyclerView _MostDiscounted;
    MainPageViewModel viewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainPageBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
         _NewlyAdded = binding.NewlyAdded;
         _MostBuyed = binding.MostBuyed;
         _MostDiscounted = binding.MostDiscounted;
         LinearLayoutManager HorizontalLayout1 = new LinearLayoutManager(binding.getRoot().getContext(), LinearLayoutManager.HORIZONTAL, false);
        _NewlyAdded.setLayoutManager(HorizontalLayout1);
        LeftRightSpacesItemDecoration SpacesItemDecoration = new LeftRightSpacesItemDecoration(15);
        _NewlyAdded.addItemDecoration(SpacesItemDecoration);
        LinearLayoutManager HorizontalLayout2 = new LinearLayoutManager(binding.getRoot().getContext(), LinearLayoutManager.HORIZONTAL, false);
        _MostBuyed.setLayoutManager(HorizontalLayout2);
        _MostBuyed.addItemDecoration(SpacesItemDecoration);
        LinearLayoutManager HorizontalLayout3 = new LinearLayoutManager(binding.getRoot().getContext(), LinearLayoutManager.HORIZONTAL, false);
        _MostDiscounted.setLayoutManager(HorizontalLayout3);
        _MostDiscounted.addItemDecoration(SpacesItemDecoration);
        viewModel = new ViewModelProvider(this).get(MainPageViewModel.class);
        viewModel.getMainPageData().observe((LifecycleOwner) this, updateMainPageData);
            return root;
    }
    Observer<MainPageData> updateMainPageData = new Observer<MainPageData>() {
        @Override
        public void onChanged(MainPageData mainPageData) {
            Adapter NewlyAddedAdapter = new Adapter(mainPageData.getNewlyAdded());
            _NewlyAdded.setAdapter(NewlyAddedAdapter);
            Adapter MostBuyedAdapter = new Adapter(mainPageData.getMostBuyed());
            _MostBuyed.setAdapter(MostBuyedAdapter);
            Adapter MostDiscountedAdapter = new Adapter(mainPageData.getMaxDiscounted());
            _MostDiscounted.setAdapter(MostDiscountedAdapter);
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
     */
}