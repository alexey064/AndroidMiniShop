package com.example.myapplication.View

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.LifecycleOwner
import Models.linked.Product
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.Adapter.CatalogAdapter
import com.example.myapplication.Other.VerticalSpacesItemDecoration
import com.example.myapplication.ViewModel.AccessoryViewModel
import com.example.myapplication.databinding.FragmentAccessoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList

class AccessoryFragment : Fragment() {
    private var binding: FragmentAccessoryBinding? = null
    var AccessoryRecView: RecyclerView? = null
    val viewModel: AccessoryViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccessoryBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        AccessoryRecView = binding!!.AccessoryRecView
        val SpacesItemDecoration = VerticalSpacesItemDecoration(15)
        AccessoryRecView!!.addItemDecoration(SpacesItemDecoration)
        viewModel.accessoryLiveData.observe((this as LifecycleOwner), updateAccessoryList)
        viewModel.getAccessories(0, 5)
        return root
    }

    var updateAccessoryList: Observer<ArrayList<Product>?> =
        Observer<ArrayList<Product>?> { products ->
            val adapter = CatalogAdapter(products)
            AccessoryRecView!!.adapter = adapter
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}