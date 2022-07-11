package com.example.myapplication.View

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import Models.linked.Product
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.Adapter.CatalogAdapter
import com.example.myapplication.Other.VerticalSpacesItemDecoration
import com.example.myapplication.ViewModel.WireHeadphonesViewModel
import com.example.myapplication.databinding.FragmentWireheadphonesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList

class WireHeadphonesFragment : Fragment(), LifecycleOwner {
    private var binding: FragmentWireheadphonesBinding? = null
    lateinit var WireHeadphoneRecView: RecyclerView
    val viewModel: WireHeadphonesViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWireheadphonesBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        WireHeadphoneRecView = binding!!.WireRecView

        val SpacesItemDecoration = VerticalSpacesItemDecoration(15)
        WireHeadphoneRecView.addItemDecoration(SpacesItemDecoration)

        viewModel.WireHeadListLiveData.observe((context as LifecycleOwner?)!!, updateWireHeadphones)
        viewModel.getWireHead(0, 5)

        return root
    }

    var updateWireHeadphones: Observer<ArrayList<Product>?> =
        Observer<ArrayList<Product>?> { products ->
            val ProductAdapter = CatalogAdapter(products)
            WireHeadphoneRecView.adapter = ProductAdapter
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}