package com.example.myapplication.View

import com.example.myapplication.NetworkService.Companion.instance
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ViewModel.CartViewModel
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.example.myapplication.R
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.LifecycleOwner
import Models.linked.Product
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.Adapter.CartAdapter
import com.example.myapplication.databinding.FragmentCartBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class CartFragment : Fragment(), View.OnClickListener {
    private var binding: FragmentCartBinding? = null
    var CartRecView: RecyclerView? = null
    var viewModel: CartViewModel? = null
    lateinit var makeOrder: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        CartRecView = root.findViewById(R.id.CartList)
        makeOrder = root.findViewById(R.id.MakeOrder)
        makeOrder.setOnClickListener(this)
        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        viewModel!!.GetCartLiveData().observe((this as LifecycleOwner), updateCartLiveData)
        return root
    }

    var updateCartLiveData = Observer<ArrayList<Product>> { products ->
        var TotalPrice = 0
        for (prod in products) {
            TotalPrice = TotalPrice + prod.price
        }
        makeOrder!!.text = TotalPrice.toString()
        val adapter = CartAdapter(products)
        CartRecView!!.adapter = adapter
    }

    override fun onClick(view: View) {
        GlobalScope.async {
            val response = instance?.api?.CompleteOrder()
            if (response?.isSuccessful==true)
            {
                findNavController(view).navigate(R.id.CartFragment)
            }
        }
    }
}