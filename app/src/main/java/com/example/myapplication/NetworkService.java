package com.example.myapplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class NetworkService {
    private static NetworkService mInstance;
    private static final String BASE_URL = "http://192.168.1.180:82/";
    private Retrofit mRetrofit;

    private NetworkService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addConverterFactory(buildGsonConverter()).build();
    }
    public static NetworkService getInstance() {
        if (mInstance == null) { mInstance = new NetworkService(); }
        return mInstance;
    }
    public void getAuthorizeInstance(String Token)
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer "+Token).build();
                return chain.proceed(request);
            }
        });
        httpClient.addInterceptor(interceptor);
        mRetrofit = new Retrofit.Builder().addConverterFactory(buildGsonConverter()).baseUrl(BASE_URL).client(httpClient.build()).build();
    }
    public MySiteApi getApi() {
        return mRetrofit.create(MySiteApi.class);
    }
    private static GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Gson myGson = gsonBuilder.create();
        return GsonConverterFactory.create(myGson);
    }
}