package com.example.myapplication.ViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.NetworkService;
import Models.ViewModel.MainPageData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainPageViewModel extends ViewModel {
    MutableLiveData<MainPageData> MainPage;
    public MainPageViewModel()
    {
        MainPage = new MutableLiveData<>();
        init();
    }
    public MutableLiveData<MainPageData> getMainPageData()
    {
        return MainPage;
    }
    public void init()
    {
        NetworkService.getInstance().getApi().getNewlyAdded().enqueue(new Callback<MainPageData>() {
            @Override
            public void onResponse(Call<MainPageData> call, Response<MainPageData> response) {
                MainPage.postValue(response.body());
            }
            @Override
            public void onFailure(Call<MainPageData> call, Throwable t) {

            }
        });
    }
}