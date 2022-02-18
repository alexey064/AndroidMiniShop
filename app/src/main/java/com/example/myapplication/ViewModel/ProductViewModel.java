package com.example.myapplication.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.NetworkService;

import Models.linked.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends ViewModel {
    MutableLiveData<Product> product;
    public ProductViewModel(int id)
    {
        product= new MutableLiveData<>();
        init(id);
    }
    public MutableLiveData<Product> GetProduct()
    {
        return product;
    }
    public void init(int id)
    {
        NetworkService.getInstance().getApi().GetProduct(id).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                product.setValue(response.body());
            }
            @Override
            public void onFailure(Call<Product> call, Throwable t) {
            }
        });
    }
    public static class MyViewModelFactory implements ViewModelProvider.Factory {
        private Application mApplication;
        private int mParam;
        public MyViewModelFactory(int param) {
            mParam = param;
        }
        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new ProductViewModel(mParam);
        }
    }
}