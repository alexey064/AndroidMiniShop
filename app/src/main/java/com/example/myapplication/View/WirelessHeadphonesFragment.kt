package com.example.myapplication.View

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ViewModel.WirelessHeadphonesViewModel
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.example.myapplication.Other.VerticalSpacesItemDecoration
import androidx.lifecycle.LifecycleOwner
import Models.linked.Product
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.Adapter.CatalogAdapter
import com.example.myapplication.databinding.FragmentWirelessheadphonesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WirelessHeadphonesFragment : Fragment() {
    private var binding: FragmentWirelessheadphonesBinding? = null
    lateinit var WirelessHeadphonesRecView: RecyclerView
    val viewModel by viewModel<WirelessHeadphonesViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentWirelessheadphonesBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        WirelessHeadphonesRecView = binding!!.WirelessRecView
        val SpacesItemDecoration = VerticalSpacesItemDecoration(15)
        WirelessHeadphonesRecView.addItemDecoration(SpacesItemDecoration)
        viewModel.wirelessHeadphonesLiveData.observe((context as LifecycleOwner?)!!, updateWirelessHeadphones)
        return root
    }
    var updateWirelessHeadphones: Observer<List<Product>> =
        Observer<List<Product>> { products ->
            val adapter = CatalogAdapter(products)
            WirelessHeadphonesRecView.adapter = adapter
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}