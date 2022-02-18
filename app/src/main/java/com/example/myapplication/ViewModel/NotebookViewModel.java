package com.example.myapplication.ViewModel;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.NetworkService;
import java.util.ArrayList;
import java.util.Date;
import Models.linked.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class NotebookViewModel  extends ViewModel {
    MutableLiveData<ArrayList<Product>> NotebookLiveData;
    ArrayList<Product> NotebookList = new ArrayList<>();
    private String TYPE="Notebook";
    public NotebookViewModel() {
        NotebookLiveData = new MutableLiveData<>();
        init();
    }
    public MutableLiveData<ArrayList<Product>> getUserMutableLiveData(){
        return NotebookLiveData;
    }
    public void init(){
        populateList();
    }
    public void populateList(){
        Date startDate = new Date();
        Log.d("TIMER",String.valueOf(startDate.getTime()));
        NetworkService.getInstance().getApi().GetCatalog(TYPE).enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                Date EndDate = new Date();
                Log.d("TIMER",String.valueOf(EndDate.getTime()));
                Log.d("TIMER", String.valueOf(EndDate.getTime()-startDate.getTime()));
                NotebookLiveData.setValue(response.body());
            }
            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });
    }
}
