package com.example.myapplication.View

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.LifecycleOwner
import Models.linked.Product
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.Adapter.CatalogAdapter
import com.example.myapplication.Other.VerticalSpacesItemDecoration
import com.example.myapplication.ViewModel.SmartphoneViewModel
import com.example.myapplication.databinding.FragmentSmartphonesBinding
import java.util.*

class SmartphonesFragment : Fragment(), LifecycleOwner {
    private var binding: FragmentSmartphonesBinding? = null
    private var SmartphoneRecView: RecyclerView? = null
    private val products: ArrayList<Product>? = null
    var viewModel: SmartphoneViewModel? = null
    var Adapter: CatalogAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSmartphonesBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        SmartphoneRecView = binding!!.SmartphoneRecView
        val SpacesItemDecoration = VerticalSpacesItemDecoration(15)
        SmartphoneRecView!!.addItemDecoration(SpacesItemDecoration)
        viewModel = ViewModelProvider(this).get(SmartphoneViewModel::class.java)
        viewModel!!.userMutableLiveData.observe(
            (context as LifecycleOwner?)!!,
            userListUpdateObserver
        )
        return root
    }

    var userListUpdateObserver: Observer<ArrayList<Product>?> =
        Observer<ArrayList<Product>?> { userArrayList ->
            if (userArrayList.size > 0) {
                Adapter = CatalogAdapter(userArrayList)
                SmartphoneRecView!!.adapter = Adapter
                val EndDate = Date()
                Log.d("TIMER", EndDate.time.toString())
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}