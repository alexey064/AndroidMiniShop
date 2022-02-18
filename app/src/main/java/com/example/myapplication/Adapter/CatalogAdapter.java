package com.example.myapplication.Adapter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import Models.linked.Product;
public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.MyView> {
    private ArrayList<Product> Products;
    public class MyView extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView CatalogItemName, CatalogItemPrice;
        ImageView CatalogPicture;
        public MyView(View view)
        {
            super(view);
            view.setOnClickListener(this);
            // initialise TextView with id
            CatalogItemName =(TextView) view.findViewById(R.id.CatalogItemName);
            CatalogPicture=(ImageView) view.findViewById(R.id.CatalogPicture);
            CatalogItemPrice=(TextView) view.findViewById(R.id.CatalogItemPrice);
        }
        @Override
        public void onClick(View view) {
            Product item = Products.get(getAdapterPosition());
            Bundle bundle = new Bundle();
            bundle.putString("id",String.valueOf(item.getProductId()));
            try {
                Navigation.findNavController(view).navigate(R.id.productFragment, bundle);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public CatalogAdapter(ArrayList<Product> horizontalList)
    {
        Products = horizontalList;
    }
    public void updateUserList(final ArrayList<Product> userArrayList) {
        this.Products.clear();
        this.Products = userArrayList;
        notifyDataSetChanged();
    }
    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.catalogitem, parent, false);
        return new MyView(itemView);
    }
    @Override
    public void onBindViewHolder(final MyView holder, final int position)
    {
        try {
            holder.CatalogItemName.setText(Products.get(position).getName());
            String price=  String.valueOf(Products.get(position).getPrice());
            if (Products.get(position).getCount()<=0)
            {
                holder.CatalogItemPrice.setText(R.string.NotInStock);
            }
            else holder.CatalogItemPrice.setText(price+"P");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        String url = Products.get(position).getPhoto();
        try{
            Picasso.get() // Context
                    .load("http://192.168.1.180:82"+url) // URL or file
                    .into(holder.CatalogPicture);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getItemCount()
    {
        return Products.size();
    }
}