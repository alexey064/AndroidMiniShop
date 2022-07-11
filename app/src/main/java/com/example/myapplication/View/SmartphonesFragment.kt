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
import com.example.myapplication.ViewModel.SmartphoneViewModel
import com.example.myapplication.databinding.FragmentSmartphonesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class SmartphonesFragment : Fragment(), LifecycleOwner {
    private var binding: FragmentSmartphonesBinding? = null
    private lateinit var SmartphoneRecView: RecyclerView
    val viewModel: SmartphoneViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSmartphonesBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        SmartphoneRecView = binding!!.SmartphoneRecView

        val SpacesItemDecoration = VerticalSpacesItemDecoration(15)
        SmartphoneRecView.addItemDecoration(SpacesItemDecoration)

        viewModel.SmartphoneListLiveData.observe((context as LifecycleOwner?)!!, userListUpdateObserver)
        viewModel.getSmartphones(0, 5)
        return root
    }

    var userListUpdateObserver: Observer<ArrayList<Product>?> =
        Observer<ArrayList<Product>?> { userArrayList ->
            SmartphoneRecView.adapter = CatalogAdapter(userArrayList)
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}