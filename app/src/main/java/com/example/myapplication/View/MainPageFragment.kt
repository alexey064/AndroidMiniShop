package com.example.myapplication.View

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.ViewModel.MainPageViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Other.LeftRightSpacesItemDecoration
import Models.linked.Product
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.Adapter.Adapter
import com.example.myapplication.databinding.FragmentMainPageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainPageFragment : Fragment() {
    private var binding: FragmentMainPageBinding? = null
    var RecNewlyAdded: RecyclerView? = null
    var RecMostBuyed: RecyclerView? = null
    var RecMostDiscounted: RecyclerView? = null
    val viewModel: MainPageViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        RecNewlyAdded = binding!!.NewlyAdded
        RecMostBuyed = binding!!.MostBuyed
        RecMostDiscounted = binding!!.MostDiscounted
        val HorizontalLayout1 =
            LinearLayoutManager(binding!!.root.context, LinearLayoutManager.HORIZONTAL, false)
        RecNewlyAdded!!.layoutManager = HorizontalLayout1
        val SpacesItemDecoration = LeftRightSpacesItemDecoration(15)
        RecNewlyAdded!!.addItemDecoration(SpacesItemDecoration)
        val HorizontalLayout2 =
            LinearLayoutManager(binding!!.root.context, LinearLayoutManager.HORIZONTAL, false)
        RecMostBuyed!!.layoutManager = HorizontalLayout2
        RecMostBuyed!!.addItemDecoration(SpacesItemDecoration)
        val HorizontalLayout3 =
            LinearLayoutManager(binding!!.root.context, LinearLayoutManager.HORIZONTAL, false)
        RecMostDiscounted!!.layoutManager = HorizontalLayout3
        RecMostDiscounted!!.addItemDecoration(SpacesItemDecoration)

        //viewModel = ViewModelProvider(this).get(MainPageViewModel::class.java)
        viewModel.NewlyAdded.observe((this as LifecycleOwner), updateNewlyAdded)
        viewModel.MaxDiscounted.observe((this as LifecycleOwner), updateMostBuyed)
        viewModel.MostBuyed.observe((this as LifecycleOwner), updateMaxDiscounted)

        viewModel.getNewlyAdded(0,5)
        viewModel.getMaxDiscounted(0, 5)
        viewModel.getMostBuyed(0, 5)
        return root
    }

    var updateNewlyAdded = Observer<ArrayList<Product>> { NewlyAdded ->
        val NewlyAddedAdapter = Adapter(NewlyAdded)
        RecNewlyAdded!!.adapter = NewlyAddedAdapter
    }
    var updateMostBuyed = Observer<ArrayList<Product>>
    { MostBuyed->
        val MostBuyedAdapter = Adapter(MostBuyed)
        RecMostBuyed!!.adapter = MostBuyedAdapter
    }
    var updateMaxDiscounted = Observer<ArrayList<Product>>
    { MaxDiscounted->
        val MostDiscountedAdapter = Adapter(MaxDiscounted)
        RecMostDiscounted!!.adapter = MostDiscountedAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}