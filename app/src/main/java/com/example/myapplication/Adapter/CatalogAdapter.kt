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

class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.MyView> {
    // List with String type
    private var Products: ArrayList<Product>? = null

    // View Holder class which
    // extends RecyclerView.ViewHolder
    inner class MyView(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        // Text View
        var CatalogItemName: TextView
        var CatalogPicture: ImageView
        var CatalogItemPrice: TextView
        override fun onClick(view: View) {
            val item = Products!![adapterPosition]
            val bundle = Bundle()
            bundle.putString("id", item.productId.toString())
            try {
                Navigation.findNavController(view).navigate(R.id.productFragment, bundle)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        init {
            view.setOnClickListener(this)
            // initialise TextView with id
            CatalogItemName = view.findViewById<View>(R.id.CatalogItemName) as TextView
            CatalogPicture = view.findViewById<View>(R.id.CatalogPicture) as ImageView
            CatalogItemPrice = view.findViewById<View>(R.id.CatalogItemPrice) as TextView
        }
    }

    // Constructor for adapter class
    // which takes a list of String type
    constructor(horizontalList: ArrayList<Product>) {
        Products = horizontalList
    }

    constructor() {}

    fun updateUserList(userArrayList: ArrayList<Product>?) {
        Products!!.clear()
        Products = userArrayList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyView {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.catalogitem,
                parent,
                false
            )
        return MyView(itemView)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {

        // Привязка конкретного элемента
        try {
            holder.CatalogItemName.text = Products!![position].name
            val price = Products!![position].price.toString()
            if (Products!![position].count <= 0) {
                holder.CatalogItemPrice.setText(R.string.NotInStock)
            } else holder.CatalogItemPrice.text = price + "P"
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val url = Products!![position].photo
        try {
            Picasso.get() // Context
                .load("http://192.168.1.180:82$url") // URL or file
                .into(holder.CatalogPicture)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return Products!!.size
    }
}