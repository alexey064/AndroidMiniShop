package com.example.myapplication.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.NetworkService;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import Models.linked.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyView> {
    ArrayList<Product> ItemList;
    @Override
    @NonNull
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent, false);
        return new MyView(itemView);
    }
    public CartAdapter(ArrayList<Product> items)
    {
        ItemList=items;
    }
    public class MyView extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView CartName, CartPrice;
        ImageView CartPhoto, DelBtn;
        public MyView(@NonNull View view) {
            super(view);
            CartName = view.findViewById(R.id.CartName);
            CartPrice= view.findViewById(R.id.CartPrice);
            CartPhoto = view.findViewById(R.id.CartPhoto);
            DelBtn= view.findViewById(R.id.CartRemove);
            DelBtn.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Product product =ItemList.get(getAdapterPosition());
            NetworkService.getInstance().getApi().DeleteShoppingCart(product.getProductId()).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Navigation.findNavController(view).navigate(R.id.CartFragment);
                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                }
            });
        }
    }
    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        Product item=ItemList.get(position);
        holder.CartName.setText(item.getName());
        holder.CartPrice.setText(String.valueOf(item.getPrice()));
        try{
            Picasso.get().load("http://192.168.1.180:82/"+item.getPhoto()).into(holder.CartPhoto);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public int getItemCount() {
        return ItemList.size();
    }}