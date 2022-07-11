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
import com.example.myapplication.ViewModel.WirelessHeadphonesViewModel
import com.example.myapplication.databinding.FragmentWirelessheadphonesBinding
import java.util.ArrayList
import org.koin.androidx.viewmodel.ext.android.viewModel

class WirelessHeadphonesFragment : Fragment() {
    private var binding: FragmentWirelessheadphonesBinding? = null
    lateinit var WirelessHeadphonesRecView: RecyclerView
    val viewModel: WirelessHeadphonesViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWirelessheadphonesBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        WirelessHeadphonesRecView = binding!!.WirelessRecView

        val SpacesItemDecoration = VerticalSpacesItemDecoration(15)
        WirelessHeadphonesRecView!!.addItemDecoration(SpacesItemDecoration)

        viewModel.wirelessHeadphonesLiveData.observe((context as LifecycleOwner?)!!, updateWirelessHeadphones)
        viewModel.getWireless(0, 5)
        return root
    }

    var updateWirelessHeadphones: Observer<ArrayList<Product>?> =
        Observer<ArrayList<Product>?> { products ->
            val adapter = CatalogAdapter(products)
            WirelessHeadphonesRecView!!.adapter = adapter
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}