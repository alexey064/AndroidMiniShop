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
import com.example.myapplication.ViewModel.NotebookViewModel
import com.example.myapplication.Adapter.CatalogAdapter
import com.example.myapplication.Other.VerticalSpacesItemDecoration
import com.example.myapplication.databinding.FragmentNotebookBinding
import java.util.*

class NotebookFragment : Fragment(), LifecycleOwner {
    private var binding: FragmentNotebookBinding? = null
    private var viewModel: NotebookViewModel? = null
    var NotebookRecView: RecyclerView? = null
    var adapter: CatalogAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotebookBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        NotebookRecView = binding!!.NotebookRecView
        val SpacesItemDecoration = VerticalSpacesItemDecoration(15)
        NotebookRecView!!.addItemDecoration(SpacesItemDecoration)
        viewModel = ViewModelProvider(this).get(NotebookViewModel::class.java)
        viewModel!!.userMutableLiveData.observe(
            (context as LifecycleOwner?)!!,
            userListUpdateObserver
        )
        return root
    }

    var userListUpdateObserver: Observer<ArrayList<Product>?> =
        Observer<ArrayList<Product>?> { userArrayList ->
            adapter = CatalogAdapter(userArrayList)
            NotebookRecView!!.adapter = adapter
            val EndDate = Date()
            Log.d("TIMER", EndDate.time.toString())
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}