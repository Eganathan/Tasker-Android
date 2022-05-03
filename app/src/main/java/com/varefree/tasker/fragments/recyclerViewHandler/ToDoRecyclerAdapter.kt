package com.varefree.tasker.fragments.recyclerViewHandler


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.varefree.tasker.R
import com.varefree.tasker.Tasker
import com.varefree.tasker.TaskerViewModel.DummyData
import com.varefree.tasker.localTransactions.LocalVM
import org.w3c.dom.Text

class ToDoRecyclerAdapter : RecyclerView.Adapter<ToDoRecyclerAdapter.ViewHolder>() {

    //var data = DummyData.dummyList
    var data = LocalVM.getList()

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoRecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_todo_recycler_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data.get(position)
        holder.titleView.setText(item.Title)
        holder.desView.setText(item.Description)
    }

    //Inner class
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleView: TextView
        var desView :TextView

        init
        {
            titleView = itemView.findViewById(R.id.titleTextR)
            desView = itemView.findViewById(R.id.descriptionTextR)
        }
    }
}