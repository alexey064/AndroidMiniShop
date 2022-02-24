package com.example.myapplication.View

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ViewModel.MainPageViewModel
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Other.LeftRightSpacesItemDecoration
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.LifecycleOwner
import Models.ViewModel.MainPageData
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.Adapter.Adapter
import com.example.myapplication.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {
    private var binding: FragmentMainPageBinding? = null
    lateinit var _NewlyAdded: RecyclerView
    lateinit var _MostBuyed: RecyclerView
    lateinit var _MostDiscounted: RecyclerView
    lateinit var viewModel: MainPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        _NewlyAdded = binding!!.NewlyAdded
        _MostBuyed = binding!!.MostBuyed
        _MostDiscounted = binding!!.MostDiscounted
        val HorizontalLayout1 =
            LinearLayoutManager(binding!!.root.context, LinearLayoutManager.HORIZONTAL, false)
        _NewlyAdded.layoutManager = HorizontalLayout1
        val SpacesItemDecoration = LeftRightSpacesItemDecoration(15)
        _NewlyAdded.addItemDecoration(SpacesItemDecoration)
        val HorizontalLayout2 =
            LinearLayoutManager(binding!!.root.context, LinearLayoutManager.HORIZONTAL, false)
        _MostBuyed.layoutManager = HorizontalLayout2
        _MostBuyed.addItemDecoration(SpacesItemDecoration)
        val HorizontalLayout3 =
            LinearLayoutManager(binding!!.root.context, LinearLayoutManager.HORIZONTAL, false)
        _MostDiscounted.layoutManager = HorizontalLayout3
        _MostDiscounted.addItemDecoration(SpacesItemDecoration)
        viewModel = ViewModelProvider(this).get(MainPageViewModel::class.java)
        viewModel.mainPageData.observe(this as LifecycleOwner, updateMainPageData)
        return root
    }

    var updateMainPageData = Observer<MainPageData> { mainPageData ->
        val NewlyAddedAdapter = Adapter(mainPageData.newlyAdded)
        _NewlyAdded.adapter = NewlyAddedAdapter
        val MostBuyedAdapter = Adapter(mainPageData.mostBuyed)
        _MostBuyed.adapter = MostBuyedAdapter
        val MostDiscountedAdapter = Adapter(mainPageData.maxDiscounted)
        _MostDiscounted.adapter = MostDiscountedAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}