package com.example.myapplication.Adapter

import com.example.myapplication.NetworkService.Companion.instance
import Models.linked.Product
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.myapplication.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.ArrayList

class CartAdapter(var ItemList: ArrayList<Product>) : RecyclerView.Adapter<CartAdapter.MyView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return MyView(itemView)
    }

    inner class MyView(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var CartName: TextView
        var CartPrice: TextView
        var CartPhoto: ImageView
        var DelBtn: ImageView
        override fun onClick(view: View) {
            val product = ItemList[adapterPosition]
            instance!!.api.DeleteShoppingCart(product.productId)!!.enqueue(object : Callback<String?> {
                    override fun onResponse(call: Call<String?>, response: Response<String?>) {
                        Navigation.findNavController(view).navigate(R.id.CartFragment)
                    }

                    override fun onFailure(call: Call<String?>, t: Throwable) {}
                })
        }

        init {
            CartName = view.findViewById(R.id.CartName)
            CartPrice = view.findViewById(R.id.CartPrice)
            CartPhoto = view.findViewById(R.id.CartPhoto)
            DelBtn = view.findViewById(R.id.CartRemove)
            DelBtn.setOnClickListener(this)
        }
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val item = ItemList[position]
        holder.CartName.text = item.name
        holder.CartPrice.text = item.price.toString()
        try {
            Picasso.get().load("http://192.168.1.180:82/" + item.photo).into(holder.CartPhoto)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return ItemList.size
    }
}