package com.varefree.tasker.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.varefree.tasker.R
import com.varefree.tasker.R.layout
import com.varefree.tasker.Tasker
import com.varefree.tasker.databinding.FragmentRecycleViewListBinding
import com.varefree.tasker.fragments.recyclerViewHandler.ToDoRecyclerAdapter

class RecycleViewListFragment : Fragment(R.layout.fragment_recycle_view_list) {
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<ToDoRecyclerAdapter.ViewHolder>

    //declaring the binding
    private lateinit var viewListFragmentBinding: FragmentRecycleViewListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //initializing the binding with an inflater
        viewListFragmentBinding = FragmentRecycleViewListBinding.inflate(inflater, container, false)


        //ON create new task button navigates to the fragment
        viewListFragmentBinding.insertTask.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_recycleViewListFragment_to_createNewTodoFragment)
        }

        layoutManager = LinearLayoutManager(context)
        viewListFragmentBinding.recyclerViews.layoutManager = layoutManager

        adapter = ToDoRecyclerAdapter()
        viewListFragmentBinding.recyclerViews.adapter = adapter


        return viewListFragmentBinding.root
    }
}