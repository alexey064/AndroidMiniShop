package com.example.myapplication.View

import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.ViewModel.NotebookViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.CatalogAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.example.myapplication.Other.VerticalSpacesItemDecoration
import androidx.lifecycle.ViewModelProvider
import Models.linked.Product
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.get
import com.example.myapplication.databinding.FragmentNotebookBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class NotebookFragment : Fragment(), LifecycleOwner {
    private var binding: FragmentNotebookBinding? = null
    private val viewModel by viewModel<NotebookViewModel>()
    lateinit var NotebookRecView: RecyclerView
    lateinit var adapter: CatalogAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotebookBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        NotebookRecView = binding!!.NotebookRecView
        val SpacesItemDecoration = VerticalSpacesItemDecoration(15)
        NotebookRecView.addItemDecoration(SpacesItemDecoration)
        viewModel.userMutableLiveData.observe((context as LifecycleOwner?)!!, userListUpdateObserver)
        return root
    }
    var userListUpdateObserver: Observer<List<Product>> =
        Observer<List<Product>> { userArrayList ->
            adapter = CatalogAdapter(userArrayList)
            NotebookRecView.adapter = adapter
        }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}