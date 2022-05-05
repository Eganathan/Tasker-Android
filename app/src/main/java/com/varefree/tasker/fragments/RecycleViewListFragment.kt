package com.varefree.tasker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.varefree.tasker.R
import com.varefree.tasker.Tasker
import com.varefree.tasker.databinding.FragmentRecycleViewListBinding
import com.varefree.tasker.fragments.recyclerViewHandler.ToDoRecyclerAdapter
import com.varefree.tasker.fragments.recyclerViewHandler.onItemClickListner
import com.varefree.tasker.localTransactions.LocalVM


class RecycleViewListFragment : Fragment(R.layout.fragment_recycle_view_list),onItemClickListner{
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<ToDoRecyclerAdapter.ViewHolder>
    private lateinit var list:List<Tasker>

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

        list = LocalVM.getList()
        adapter = ToDoRecyclerAdapter(list,this)
        viewListFragmentBinding.recyclerViews.adapter = adapter


        return viewListFragmentBinding.root
    }

    override fun onItemClick(position: Int) {
        var item = list.get(position)

        val navController: NavController = this.findNavController()
        val bund :Bundle = Bundle()
        bund.putLong("ID",item.ID)
        navController.navigate(R.id.action_recycleViewListFragment_to_viewTodoFragment,bund)

    }
}
