package com.example.myapplication.View

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import Models.linked.Product
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.Adapter.CatalogAdapter
import com.example.myapplication.Other.VerticalSpacesItemDecoration
import com.example.myapplication.ViewModel.SmartphoneViewModel
import com.example.myapplication.databinding.FragmentSmartphonesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SmartphonesFragment : Fragment(), LifecycleOwner {
    private var binding: FragmentSmartphonesBinding? = null
    private lateinit var SmartphoneRecView: RecyclerView
    val viewModel by viewModel<SmartphoneViewModel>()

    lateinit var Adapter: CatalogAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSmartphonesBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        SmartphoneRecView = binding!!.SmartphoneRecView
        val SpacesItemDecoration = VerticalSpacesItemDecoration(15)
        SmartphoneRecView.addItemDecoration(SpacesItemDecoration)
        viewModel.userMutableLiveData.observe((context as LifecycleOwner?)!!, userListUpdateObserver)
        return root
    }

    var userListUpdateObserver: Observer<List<Product>> =
        Observer<List<Product>> { userArrayList ->
                Adapter = CatalogAdapter(userArrayList)
                SmartphoneRecView.adapter = Adapter
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}