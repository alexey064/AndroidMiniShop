package com.example.myapplication.Adapter

import Models.linked.Product
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.os.Bundle
import com.example.myapplication.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso
import java.lang.Exception
import java.util.ArrayList

class CatalogAdapter(private var Products: List<Product>) :
    RecyclerView.Adapter<CatalogAdapter.MyView>() {
    inner class MyView(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var CatalogItemName: TextView
        var CatalogItemPrice: TextView
        var CatalogPicture: ImageView
        override fun onClick(view: View) {
            val item = Products[adapterPosition]
            val bundle = Bundle()
            bundle.putString("id", item.productId.toString())
            try {
                Navigation.findNavController(view).navigate(R.id.productFragment, bundle)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        init {
            view.setOnClickListener(this)
            // initialise TextView with id
            CatalogItemName = view.findViewById<View>(R.id.CatalogItemName) as TextView
            CatalogPicture = view.findViewById<View>(R.id.CatalogPicture) as ImageView
            CatalogItemPrice = view.findViewById<View>(R.id.CatalogItemPrice) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.catalogitem, parent, false)
        return MyView(itemView)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        try {
            holder.CatalogItemName.text = Products[position].name
            val price = Products[position].price.toString()
            if (Products[position].count <= 0) {
                holder.CatalogItemPrice.setText(R.string.NotInStock)
            } else holder.CatalogItemPrice.text = price + "P"
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val url = Products[position].photo
        try {
            Picasso.get() // Context
                .load("http://192.168.1.180:82$url") // URL or file
                .into(holder.CatalogPicture)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return Products.size
    }
}