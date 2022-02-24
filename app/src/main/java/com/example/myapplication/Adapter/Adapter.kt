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

class Adapter(private val Products: List<Product>?) : RecyclerView.Adapter<Adapter.MyView>() {
    inner class MyView(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var ItemName: TextView
        var Picture: ImageView
        var ItemPrice: TextView
        override fun onClick(view: View) {
            val item = Products?.get(adapterPosition)
            val bundle = Bundle()
            bundle.putString("id", item?.productId.toString())
            try {
                Navigation.findNavController(view).navigate(R.id.productFragment, bundle)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        init {
            view.setOnClickListener(this)
            // initialise TextView with id
            ItemName = view.findViewById<View>(R.id.ItemName) as TextView
            Picture = view.findViewById<View>(R.id.ItemPicture) as ImageView
            ItemPrice = view.findViewById<View>(R.id.ItemPrice) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyView(itemView)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.ItemName.text = Products?.get(position)?.name
        val price = Products?.get(position)?.price.toString()
        if (Products!![position].count <= 0) {
            holder.ItemPrice.setText(R.string.NotInStock)
        } else holder.ItemPrice.text = price + "P"
        val url = Products[position].photo
        try {
            Picasso.get().load("http://192.168.1.180:82$url")
                .into(holder.Picture)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return Products!!.size
    }
}