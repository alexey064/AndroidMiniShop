package com.example.myapplication.Adapter;
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

import java.util.ArrayList;

import Models.linked.Product;
public class Adapter extends RecyclerView.Adapter<Adapter.MyView> {
    private ArrayList<Product> Products;
    public class MyView extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView ItemName;
        ImageView Picture;
        TextView ItemPrice;

        public MyView(View view)
        {
            super(view);
            view.setOnClickListener(this);
            // initialise TextView with id
            ItemName =(TextView) view.findViewById(R.id.ItemName);
            Picture=(ImageView) view.findViewById(R.id.ItemPicture);
            ItemPrice=(TextView) view.findViewById(R.id.ItemPrice);
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
    public Adapter(ArrayList<Product> horizontalList)
    {
        this.Products = horizontalList;
    }
    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new MyView(itemView);
    }
    @Override
    public void onBindViewHolder(final MyView holder, final int position)
    {
            holder.ItemName.setText(Products.get(position).getName());
            String price=  String.valueOf(Products.get(position).getPrice());
            if (Products.get(position).getCount()<=0)
            {
                holder.ItemPrice.setText(R.string.NotInStock);
            }
            else holder.ItemPrice.setText(price+"P");
        String url = Products.get(position).getPhoto();
        try{
            Picasso.get().load("http://192.168.1.180:82"+url)
                    .into(holder.Picture);
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