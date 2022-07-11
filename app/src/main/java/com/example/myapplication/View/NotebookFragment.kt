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
import com.example.myapplication.ViewModel.NotebookViewModel
import com.example.myapplication.Adapter.CatalogAdapter
import com.example.myapplication.Other.VerticalSpacesItemDecoration
import com.example.myapplication.databinding.FragmentNotebookBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class NotebookFragment : Fragment(), LifecycleOwner {
    private var binding: FragmentNotebookBinding? = null
    private val viewModel: NotebookViewModel by viewModel()
    var NotebookRecView: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotebookBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        NotebookRecView = binding!!.NotebookRecView

        val SpacesItemDecoration = VerticalSpacesItemDecoration(15)
        NotebookRecView!!.addItemDecoration(SpacesItemDecoration)
        viewModel.NotebookListLiveData.observe((context as LifecycleOwner?)!!, userListUpdateObserver)
        viewModel.GetNotebook(0, 5)
        return root
    }

    var userListUpdateObserver: Observer<ArrayList<Product>?> =
        Observer<ArrayList<Product>?> { userArrayList ->
            NotebookRecView!!.adapter = CatalogAdapter(userArrayList)
        }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}